package com.example.diary2101107parkjinseok.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.myrecoder.model.MyRecord

@Dao
interface MyDao {
    @Query("select * from MyRecord order by rid desc")
    fun selectAll():List<MyRecord>
    @Insert(onConflict = IGNORE)
    suspend fun insert(record:MyRecord)
    @Delete
    suspend fun delete(record:MyRecord)
}