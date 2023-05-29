package com.startandroid.k_094_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btnStart).setOnClickListener {
            startService(Intent("MyService_first").putExtra("name", "value"))
        }
    }
}
//START_NOT_STICKY – сервис не будет перезапущен после того, как был убит системой

//START_STICKY – сервис будет перезапущен после того, как был убит системой

//START_REDELIVER_INTENT – сервис будет перезапущен после того, как был убит системой.
// Кроме этого, сервис снова получит все вызовы startService,
// которые не были завершены методом stopSelf(startId).