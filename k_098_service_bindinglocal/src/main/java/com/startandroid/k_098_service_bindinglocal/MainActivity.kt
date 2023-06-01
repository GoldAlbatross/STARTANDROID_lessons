package com.startandroid.k_098_service_bindinglocal

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.startandroid.k_098_service_bindinglocal.MyService.MyBinder
import com.startandroid.k_098_service_bindinglocal.databinding.ActivityMainBinding

const val LOG = "qqq"
class MainActivity : AppCompatActivity() {

    private val binding by lazy (LazyThreadSafetyMode.NONE){
        ActivityMainBinding.inflate(layoutInflater) }

  private var bound = false
  private lateinit var serviceConnection: ServiceConnection
  private lateinit var intent: Intent
  private lateinit var service: MyService
  var interval: Long = 0

  /** Called when the activity is first created.  */
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    intent = Intent(this, MyService::class.java)
    serviceConnection = object : ServiceConnection {
      override fun onServiceConnected(name: ComponentName?, binder: IBinder) {
        Log.d(LOG, "MainActivity onServiceConnected")
        service = (binder as MyBinder).service
        bound = true
      }
      override fun onServiceDisconnected(name: ComponentName?) {
        Log.d(LOG, "MainActivity onServiceDisconnected")
        bound = false
      }
    }
    setListeners()
  }


  override fun onStart() {
    super.onStart()
    bindService(intent, serviceConnection, 0)
  }

  override fun onStop() {
    super.onStop()
    if (!bound) return
    unbindService(serviceConnection)
    bound = false
  }

  private fun setListeners() {
    binding.apply {
      btnStart.setOnClickListener { startService(intent) }
      btnUp.setOnClickListener { onClickUp() }
      btnDown.setOnClickListener { onClickDown() }
    }
  }

  private fun onClickUp() {
    if (!bound) return
    interval = service.upInterval(500)
    binding.interval.text = "interval = $interval"
  }

  private fun onClickDown() {
    if (!bound) return
    interval = service.downInterval(500)
    binding.interval.text = "interval = $interval"
  }
}