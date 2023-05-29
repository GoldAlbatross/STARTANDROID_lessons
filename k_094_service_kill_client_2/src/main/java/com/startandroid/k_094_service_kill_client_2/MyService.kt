package com.startandroid.k_094_service_kill_client_2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.concurrent.TimeUnit

class MyService: Service() {
    private val LOG_TAG = "qqq"

    override fun onCreate() {
        super.onCreate()
        Log.d(LOG_TAG, "MyService onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "MyService onDestroy")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(LOG_TAG, "MyService onStartCommand")
        readFlags(flags)
        Thread(MyRun(startId)).start()
        return START_NOT_STICKY
    }

    override fun onBind(arg0: Intent?): IBinder? {
        return null
    }

    private fun readFlags(flags: Int) {
        if (flags and START_FLAG_REDELIVERY == START_FLAG_REDELIVERY)
            Log.d(LOG_TAG, "START_FLAG_REDELIVERY")
        if (flags and START_FLAG_RETRY == START_FLAG_RETRY)
            Log.d(LOG_TAG, "START_FLAG_RETRY")
    }

    inner class MyRun(private val startId: Int) : Runnable {

        override fun run() {
            Log.d(LOG_TAG, "run#$startId start")
            try {
                TimeUnit.SECONDS.sleep(15)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            stop()
        }

        private fun stop() {
            Log.d(LOG_TAG, "run#$startId end, stopSelfResult($startId) = ${stopSelfResult(startId)}")
        }
    }

}