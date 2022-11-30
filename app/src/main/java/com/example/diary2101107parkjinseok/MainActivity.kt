package com.example.diary2101107parkjinseok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diary2101107parkjinseok.databinding.ActivityMainBinding
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.*

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter = DiaryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val manager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = adapter

        binding.createDiary.setOnClickListener {
            val intent= Intent(this, CreateDiaryActivity::class.java)
            startActivity(intent)
        }
    }
}