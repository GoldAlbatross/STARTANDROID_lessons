package com.startandroid.k_097_service_bind_client

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d(LOG, "Service onCreate")
    }

    override fun onBind(intent: Intent?): IBinder {
        Log.d(LOG, "Service onBind")
        return Binder()
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(LOG, "Service onRebind")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(LOG, "Service onUnbind")
        //return super.onUnbind(intent)
        return true // можно много раз onBind/onRebind, правильно работает
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG, "Service onDestroy")
    }
}