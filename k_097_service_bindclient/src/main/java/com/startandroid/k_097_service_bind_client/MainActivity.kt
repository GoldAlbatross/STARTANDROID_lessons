package com.startandroid.k_097_service_bind_client

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.startandroid.k_097_service_bind_client.databinding.ActivityMainBinding
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


const val LOG = "qqq"
class MainActivity : AppCompatActivity() {

    private var bound = false
    private lateinit var intent: Intent
    private lateinit var service: MyService
    private lateinit var sc: ServiceConnection
    private val binding by lazy (LazyThreadSafetyMode.NONE){
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val prefs by lazy {
        getSharedPreferences("count", Service.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent = Intent("0972_service_bind_server").setPackage(packageName)
        sc = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
                Log.d(LOG, "MainActivity onServiceConnected")
                service = (binder as MyService.MyBinder).service
                bound = true
            }
            override fun onServiceDisconnected(name: ComponentName?) {
                Log.d(LOG, "MainActivity onServiceDisconnected")
                bound = false
            }
        }
        setListeners()




    }

    override fun onDestroy() {
        super.onDestroy()
        onClickUnBind()
    }

    private fun setListeners() {
        binding.apply {
            btnStart.setOnClickListener { startService(intent) }
            btnBind.setOnClickListener {
                bindService(intent, sc, BIND_AUTO_CREATE)
                //draw()
                drawFromPrefs()
            }
            btnStop.setOnClickListener { stopService(intent) }
            btnUnBind.setOnClickListener { onClickUnBind() }
        }
    }

    private fun drawFromPrefs() {
        lifecycleScope.launch {
            prefs.getFlowForKey("int")
                .stateIn(lifecycleScope, SharingStarted.Eagerly, 1)
                .collect {
                    binding.btnStart.text = it.toString()
            }

        }
    }

    private fun draw() {
        lifecycleScope.launch {
            while (!bound || !this@MainActivity::service.isInitialized) {
                delay(100)
            }

            service.intState.collect {
                binding.btnStart.text = it.toString()
            }

        }
    }



    private fun onClickUnBind() {
        if (!bound) return
        unbindService(sc)
        bound = false
    }
}