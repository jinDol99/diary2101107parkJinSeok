package com.example.diary2101107parkjinseok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.diary2101107parkjinseok.databinding.ActivityMainBinding
import com.example.diary2101107parkjinseok.databinding.ActivityCreateDiaryBinding
import com.example.diary2101107parkjinseok.model.MyDatabase
import com.example.diary2101107parkjinseok.model.MyDao
import com.example.diary2101107parkjinseok.model.MyDiary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*

class CreateDiaryActivity : AppCompatActivity() {
    // 바인딩 할 xml 파일을 binding 객체 형태로 생성
    private val binding by lazy {
        ActivityCreateDiaryBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonDiaryCreateApply.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val content = binding.editTextContent.text.toString()

            if(title.isNotEmpty() && content.isNotEmpty()) {
                val time:String = Date().toString()
                CoroutineScope(Dispatchers.IO).launch {
                    val db = MyDatabase.getInstance(this@CreateDiaryActivity)
                    db?.myDao()?.insert(MyDiary(0, title,content, time))
                }
                val intent= Intent(this, MainActivity::class.java) // 지금 내가 하고 싶은 동작에 대한 주문서
                startActivity(intent)
            }
        }

        binding.buttonDiaryCreateUndo.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java) // 지금 내가 하고 싶은 동작에 대한 주문서
            startActivity(intent)
        }
    }
}