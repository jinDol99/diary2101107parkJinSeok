package com.example.diary2101107parkjinseok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diary2101107parkjinseok.model.MyDiary
import com.example.diary2101107parkjinseok.R

class DiaryAdapter : RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>() {
    private var data = listOf<MyDiary>()

    fun updateData(data:List<MyDiary>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        return DiaryViewHolder(v)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        val record = data[position]
        holder.textViewTime.text = record.time
        holder.textViewTitle.text = record.title
    }

    override fun getItemCount(): Int {
        return data.size
    }

    // RecyclerView에 사용될
    class DiaryViewHolder(v: View): RecyclerView.ViewHolder(v){
        val textViewTime: TextView = v.findViewById(R.id.textViewTime)
        val textViewTitle: TextView = v.findViewById(R.id.textViewTitle)
    }
}