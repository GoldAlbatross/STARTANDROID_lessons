package com.startandroid.k_095_service_pendingintent

import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    companion object {
        const val STATUS_START = 100
        const val STATUS_FINISH = 200
        const val TIME = "time"
        const val P_INTENT = "pendingIntent"
        const val PARAM_RESULT = "result"
    }

    private lateinit var tvTask: TextView
    private lateinit var pending: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTask = findViewById(R.id.tvTask3)
        tvTask.text = getString(R.string.task)
        findViewById<Button>(R.id.btnStart).setOnClickListener { openServiceForResult() }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("qqq", "onDestroy()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("qqq", "onStop()")
    }
    private fun openServiceForResult() {
        Log.d("qqq", "sendTask")
        pending = createPendingResult(111, Intent(), FLAG_UPDATE_CURRENT)
        val intent = Intent(applicationContext, MyService::class.java).apply {
            putExtra(TIME, 7)
            putExtra(P_INTENT, pending)
        }
        startService(intent)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Ловим сообщения о старте задач
        if (resultCode == STATUS_START) {
            tvTask.text = "STATUS_START"
        }

        // Ловим сообщения об окончании задач
        if (resultCode == STATUS_FINISH) {
            val result = data?.getIntExtra(PARAM_RESULT, 0)
            tvTask.text = "Task finish, result = $result"
        }
    }

    // Для создания пендинг интента из сервиса
//    override fun onNewIntent(intent: Intent?) {
//        super.onNewIntent(intent)
//
//        val result = intent?.getIntExtra(PARAM_RESULT, 0)
//        tvTask.text = "Task finish, result = $result"
//    }
}

