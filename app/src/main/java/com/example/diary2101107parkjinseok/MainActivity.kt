package com.example.diary2101107parkjinseok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myrecoder.databinding.ActivityMainBinding
import com.example.myrecoder.model.MyDatabase
import com.example.myrecoder.model.MyRecord
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonRecord.setOnClickListener {
            val food = binding.editTextFoodName.text.toString()
            if(food.isNotEmpty()) {
                val time:String = Date().toString()//LocalDateTime.now().toString()
                CoroutineScope(Dispatchers.IO).launch {
                    val db = MyDatabase.getInstance(this@MainActivity)
                    db?.myDao()?.insert(MyRecord(0, food, time))
                }
            }
        }

        binding.buttonHistory.setOnClickListener {
            val intent= Intent(this, HistoryActivity::class.java) // 지금 내가 하고 싶은 동작에 대한 주문서
            startActivity(intent)
        }
    }
}