package com.example.diary2101107parkjinseok.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyDiary(
    @PrimaryKey (autoGenerate = true) val rid:Int,
    val title:String,
    val content:String,
    val time:String
)