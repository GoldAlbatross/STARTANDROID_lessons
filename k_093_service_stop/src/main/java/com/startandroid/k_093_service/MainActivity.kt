package com.startandroid.k_093_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.start_btn).setOnClickListener {
            startService(Intent(this, MyService::class.java).putExtra("time",7))
            startService(Intent(this, MyService::class.java).putExtra("time",2))
            startService(Intent(this, MyService::class.java).putExtra("time",4))
        }
    }
}