package com.startandroid.k_097_service_bind_client

import android.app.Service
import android.content.Intent
import android.content.SharedPreferences
import android.os.Binder
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MyService : Service() {

    private val prefs by lazy {
        application.getSharedPreferences("count", MODE_PRIVATE)
    }
    private val _intState = MutableStateFlow(0)
    val intState = _intState.asStateFlow()

    override fun onCreate() {
        super.onCreate()
        Log.d(LOG, "Service onCreate")
        doWork()
    }

    private fun doWork() {
        var count = 0
        var pref = 100
        CoroutineScope(Job() + Dispatchers.IO).launch {
            while (count < 20) {
                prefs.edit().putInt("int", --pref).commit()
                delay(1000)
                _intState.value = ++count

            }

        }
    }

    override fun onBind(intent: Intent?): IBinder {
        Log.d(LOG, "Service onBind")
        return MyBinder()
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

    inner class MyBinder : Binder() {
        val service: MyService = this@MyService
    }
}

fun SharedPreferences.getFlowForKey(keyFlow: String) = callbackFlow<Int> {
    val listener = SharedPreferences.OnSharedPreferenceChangeListener { value, key ->
        if (keyFlow == key) {
            trySend(value.getInt(key, 0))
        }
    }
    registerOnSharedPreferenceChangeListener(listener)
    awaitClose { unregisterOnSharedPreferenceChangeListener(listener) }
}.buffer(Channel.UNLIMITED)
