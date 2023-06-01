package com.startandroid.k_095_service_pendingintent

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MyService : Service() {

    private val qqq = "qqq"
    private lateinit var es: ExecutorService

    override fun onCreate() {
        super.onCreate()
        Log.d(qqq, "MyService onCreate")
        es = Executors.newFixedThreadPool(1)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(qqq, "MyService onDestroy")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(qqq, "MyService onStartCommand: id=$startId")
        val time = intent?.getIntExtra(MainActivity.TIME, 1)!!
        val pi: PendingIntent = intent.getParcelableExtra(MainActivity.P_INTENT)!!
        val mr = MyRun(time, startId, pi)
        es.execute(mr)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(arg0: Intent?): IBinder? {
        return null
    }

    inner class MyRun(private val time: Int, private val startId: Int, private val pi: PendingIntent) : Runnable {

        override fun run() {
            Log.d("qqq", "MyRun#$startId start, time = $time")
            try {
                // сообщаем о старте задачи
                pi.send(MainActivity.STATUS_START)

                // начинаем выполнение задачи
                TimeUnit.SECONDS.sleep(time.toLong())

                // сообщаем об окончании задачи
                val intent = Intent().putExtra(MainActivity.PARAM_RESULT, time * 100)
                pi.send(this@MyService, MainActivity.STATUS_FINISH, intent)

            } catch (e: InterruptedException) {
                e.printStackTrace()
            } catch (e: PendingIntent.CanceledException) {
                e.printStackTrace()
            }
            val x = stopSelfResult(startId)
            Log.d("qqq", "MyRun#$startId end, stopSelfResult($startId) = $x")

        }
    }
}