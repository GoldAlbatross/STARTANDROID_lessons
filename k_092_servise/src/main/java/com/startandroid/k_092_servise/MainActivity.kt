package com.startandroid.k_092_servise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //startService(Intent(this, MyService::class.java))

        val start = findViewById<Button>(R.id.btnStart)
        val stop = findViewById<Button>(R.id.btnStop)

        start.setOnClickListener {
            startService(Intent(this, MyService::class.java))
        }

        stop.setOnClickListener {
            stopService(Intent(this, MyService::class.java))
        }
    }
}