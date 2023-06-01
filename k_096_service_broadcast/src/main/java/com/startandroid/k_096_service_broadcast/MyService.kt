package com.startandroid.k_096_service_broadcast

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class MyService: Service() {


    private lateinit var es: ExecutorService

    override fun onCreate() {
        super.onCreate()
        Log.d(LOG, "Service onCreate")
        es = Executors.newFixedThreadPool(2)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG, "+++onDestroy+++")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d(LOG, "Service onStartCommand: handling ${startId}th command")
        val time = intent.getIntExtra(MainActivity.TIME_KEY, 1)
        val task = intent.getIntExtra(MainActivity.TASK_KEY, 0)
        es.execute(RunTasks(startId, time, task))
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    inner class RunTasks(var startId: Int, var time: Int, var task: Int) : Runnable {

        override fun run() {
            val intent = Intent(MainActivity.BROADCAST_ACTION)
            Log.d(LOG, "Task#$startId start")
            try {
                // сообщаем о старте задачи
                intent.putExtra(MainActivity.TASK_KEY, task)
                intent.putExtra(MainActivity.STATUS_KEY, MainActivity.START)
                sendBroadcast(intent)

                // начинаем выполнение задачи
                TimeUnit.SECONDS.sleep(time.toLong())

                // сообщаем об окончании задачи
                intent.putExtra(MainActivity.STATUS_KEY, MainActivity.FINISH)
                intent.putExtra(MainActivity.RESULT_KEY, "выполнено за $time секунд")
                sendBroadcast(intent)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            stop()
        }

        private fun stop() {
            Log.d(LOG, "Task#$startId end, stopSelfResult($startId) = ${stopSelfResult(startId)}")
        }
    }

}


