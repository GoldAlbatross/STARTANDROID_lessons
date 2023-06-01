package com.startandroid.k_096_service_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.startandroid.k_096_service_broadcast.databinding.ActivityMainBinding

const val LOG = "qqq"
class MainActivity : AppCompatActivity() {

    private val binding by lazy (LazyThreadSafetyMode.NONE){
        ActivityMainBinding.inflate(layoutInflater) }
    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.task1.text = getString(R.string.task)
        binding.task2.text = getString(R.string.task)
        binding.task3.text = getString(R.string.task)

        // создаем BroadcastReceiver
        val receiver = object : BroadcastReceiver() {

            // действия при получении сообщений
            override fun onReceive(context: Context?, intent: Intent) {

                val task: Int = intent.getIntExtra(TASK_KEY, 0)
                val status: String = intent.getStringExtra(STATUS_KEY) ?: "error"
                Log.d(LOG, "onReceive: task = $task, status = $status")

                // Ловим сообщения о старте задач
                if (status == START) {
                    when (task) {
                        TASK1 -> binding.task1.text = "Task1 start"
                        TASK2 -> binding.task2.text = "Task2 start"
                        TASK3 -> binding.task3.text = "Task3 start"
                    }
                }

                // Ловим сообщения об окончании задач
                if (status == FINISH) {
                    val result: String = intent.getStringExtra(RESULT_KEY) ?: "error"
                    when (task) {
                        TASK1 -> binding.task1.text = "Task1 finish, result = $result"
                        TASK2 -> binding.task2.text = "Task2 finish, result = $result"
                        TASK3 -> binding.task3.text = "Task3 finish, result = $result"
                    }
                }
            }
        }

        // создаем фильтр для BroadcastReceiver
        val intFilter = IntentFilter(BROADCAST_ACTION)

        // регистрируем (включаем) BroadcastReceiver
        registerReceiver(receiver, intFilter)

        binding.btnStart.setOnClickListener { onClickStart() }
    }

    override fun onDestroy() {
        super.onDestroy()

        // дерегистрируем (выключаем) BroadcastReceiver
        unregisterReceiver(receiver)
    }

    private fun onClickStart() {

        // Создаем Intent для вызова сервиса, кладем туда параметр времени и код задачи
        Intent(this, MyService::class.java).apply {
            putExtra(TIME_KEY, 7)
            putExtra(TASK_KEY, TASK1)
            // стартуем сервис
            startService(this)
        }

        Intent(this, MyService::class.java).apply {
            putExtra(TIME_KEY, 4)
            putExtra(TASK_KEY, TASK2)
            startService(this)
        }

        Intent(this, MyService::class.java).apply {
            putExtra(TIME_KEY, 6)
            putExtra(TASK_KEY, TASK3)
            startService(this)
        }
    }

    companion object {

        const val TASK1 = 1
        const val TASK2 = 2
        const val TASK3 = 3

        const val START = "start"
        const val FINISH = "finish"

        const val TIME_KEY = "time"
        const val TASK_KEY = "task"
        const val RESULT_KEY = "result"
        const val STATUS_KEY = "status"

        const val BROADCAST_ACTION = "intent from service to activity over broadcast"
    }
}