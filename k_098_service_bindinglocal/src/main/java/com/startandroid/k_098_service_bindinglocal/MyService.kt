package com.startandroid.k_098_service_bindinglocal

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.Timer
import java.util.TimerTask

class MyService: Service() {


    private var binder = MyBinder()
    private lateinit var timer: Timer
    private var timerTask: TimerTask? = null
    private var interval: Long = 1000

    override fun onCreate() {
        super.onCreate()
        Log.d(LOG, "Service onCreate")
        timer = Timer()
        schedule()
    }

    override fun onBind(arg0: Intent?): IBinder {
        Log.d(LOG, "Service onBind")
        return binder
    }

    private fun schedule() {
        timerTask?.cancel()
        if (interval > 0) {
            timerTask = object : TimerTask() {
                override fun run() { Log.d(LOG, "run") }
            }
            timer.schedule(timerTask, 1000, interval)
        }
    }

    fun upInterval(gap: Long): Long {
        interval += gap
        schedule()
        return interval
    }

    fun downInterval(gap: Long): Long {
        interval -= gap
        if (interval < 0) interval = 0
        schedule()
        return interval
    }

    inner class MyBinder : Binder() {
        val service: MyService
            get() = this@MyService
    }
}