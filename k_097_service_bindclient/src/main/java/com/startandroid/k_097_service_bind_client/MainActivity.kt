package com.startandroid.k_097_service_bind_client

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.startandroid.k_097_service_bind_client.databinding.ActivityMainBinding


const val LOG = "qqq"
class MainActivity : AppCompatActivity() {

    private lateinit var intent: Intent
    private val binding by lazy (LazyThreadSafetyMode.NONE){
        ActivityMainBinding.inflate(layoutInflater) }
    var bound = false
    lateinit var sc: ServiceConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent = Intent("0972_service_bind_server").setPackage(packageName)

        sc = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
                Log.d(LOG, "MainActivity onServiceConnected")
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
            btnBind.setOnClickListener { bindService(intent, sc, 0) }
            btnStop.setOnClickListener { stopService(intent) }
            btnUnBind.setOnClickListener { onClickUnBind() }
        }
    }



    private fun onClickUnBind() {
        if (!bound) return
        unbindService(sc)
        bound = false
    }
}