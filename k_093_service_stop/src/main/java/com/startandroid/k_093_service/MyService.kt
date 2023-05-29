package com.startandroid.k_093_service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MyService : Service() {

    private val qqq = "qqq"

    private lateinit var es: ExecutorService
    private var someRes: Any? = null

    override fun onCreate() {
        super.onCreate()
        Log.d(qqq, "MyService onCreate")
        es = Executors.newFixedThreadPool(3)
        someRes = Object()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(qqq, "MyService onDestroy")
        someRes = null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(qqq, "MyService onStartCommand")
        val time = intent?.getIntExtra("time", 1) ?: 1
        val mr = MyRun(time, startId)
        es.execute(mr)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(arg0: Intent?): IBinder? {
        return null
    }

    inner class MyRun(private val time: Int, private val startId: Int) : Runnable {
        override fun run() {
            Log.d(qqq, "MyRun#$startId start, time = $time")
            try {
                TimeUnit.SECONDS.sleep(time.toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            try {
                Log.d(qqq, "MyRun#$startId someRes = ${someRes?.javaClass}")
            } catch (e: NullPointerException) {
                Log.d(qqq, "MyRun#$startId error, null pointer")
            }
            stop()
        }

        private fun stop() {
            Log.d(qqq, "MyRun#$startId end, stopSelf($startId)")
            stopSelf(startId)
        }
    }
}
