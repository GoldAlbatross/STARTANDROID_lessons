package com.startandroid.k_095_service_pendingintent

import android.app.PendingIntent
import android.app.PendingIntent.FLAG_ONE_SHOT
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(),PendingIntent.OnFinished {

    companion object {
        const val STATUS_START = 100
        const val STATUS_FINISH = 200
        const val TIME = "time"
        const val P_INTENT = "pendingIntent"
        const val PARAM_RESULT = "result"
    }

    private lateinit var tvTask: TextView
    private lateinit var pi: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvTask = findViewById(R.id.tvTask3)
        tvTask.text = getString(R.string.task)

        findViewById<Button>(R.id.btnStart).setOnClickListener { openServiceForResult() }
    }

    private fun openServiceForResult() {
        Log.d("qqq", "sendTask")
        pi = createPendingResult(111, Intent(),FLAG_ONE_SHOT)
        pi.intentSender.creatorUserHandle
        val intent = Intent(this, MyService::class.java).apply {
            putExtra(TIME, 7)
            putExtra(P_INTENT, pi)
        }
        startService(intent)
    }

    override fun onSendFinished(
        pendingIntent: PendingIntent?,
        intent: Intent?,
        resultCode: Int,
        resultData: String?,
        resultExtras: Bundle?
    ) {
        Log.d("qqq", "pendingIntent: $pendingIntent")
        Log.d("qqq", "intent: $intent")
        Log.d("qqq", "resultCode: $resultCode")
        Log.d("qqq", "resultData: $resultData")
        Log.d("qqq", "resultExtras: $resultExtras")
        tvTask.text = "Task3 finish, result = $resultCode"
    }
}

