package com.example.diary2101107parkjinseok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.diary2101107parkjinseok.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diary2101107parkjinseok.model.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    // 레이아웃 파일(xml)과 현재 파일(kt)와 바인딩
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter = DiaryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 레이아웃 매니저를 Recycler View 형태로 바인딩
        val manager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = adapter

        // DB 데이터를 가져오기 위한 Coroutine
        // 현재는 해당 코드 작동시 앱 자체를 실행하지 못하는 오류로 인해 주석 처리함.
        /*CoroutineScope(Dispatchers.IO).launch {
            val dao = MyDatabase.getInstance(this@MainActivity).myDao()
            val list = dao.selectAll()
            list.forEach {
                Log.d("List", it.toString())
                withContext(Dispatchers.Main) {
                    adapter.updateData(list)
                }
            }
        }*/

        // [+] 플로팅버튼 클릭 시 CreateDiaryActivity.kt 으로 연결
        binding.createDiary.setOnClickListener {
            val intent= Intent(this, CreateDiaryActivity::class.java)
            startActivity(intent)
        }
    }
}