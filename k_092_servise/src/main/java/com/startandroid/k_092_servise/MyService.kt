package com.startandroid.k_092_servise

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import java.util.concurrent.TimeUnit


class MyService: Service() {


    override fun onCreate() {
        super.onCreate()
        Log.d("qqq", "onCreate: сервис создается")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        someTask()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("qqq", "onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d("qqq", "onBind")
        return null
    }

    private fun someTask() {
        Log.d("qqq", "onStartCommand: сервис выполняет работу")
        Thread {
            for (i in 1..9) {
                Log.d("qqq", "i = $i")
                try {
                    TimeUnit.SECONDS.sleep(1)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            stopSelf()
        }.start()

    }
}