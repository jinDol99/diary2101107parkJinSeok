package com.example.diary2101107parkjinseok

import HistoryAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diary2101107parkjinseok.databinding.ActivityHistoryBinding
import com.example.diary2101107parkjinseok.model.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityHistoryBinding.inflate(layoutInflater)
    }
    private val adapter = HistoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val manager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = adapter

        CoroutineScope(Dispatchers.IO).launch {
            val dao = MyDatabase.getInstance(this@HistoryActivity).myDao()
            val list = dao.selectAll()
            list.forEach {
                Log.d("List", it.toString())
                withContext(Dispatchers.Main) {
                    adapter.updateData(list)
                }
            }
        }
    }
}