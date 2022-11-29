package com.example.diary2101107parkjinseok.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyList {
    @PrimaryKey (autoGenerate = true) val rid:Int,
    val food:String,
    val time:String
}