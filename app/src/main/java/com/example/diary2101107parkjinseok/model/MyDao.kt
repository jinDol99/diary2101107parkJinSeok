package com.example.diary2101107parkjinseok.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.diary2101107parkjinseok.model.MyDiary

// SQL 문장을 통해 입력, 수정, 삭제를 담당.
// 현재는
@Dao
interface MyDao {
    @Query("select * from MyDiary order by rid desc")
    fun selectAll():List<MyDiary>
    @Insert(onConflict = IGNORE)
    suspend fun insert(record:MyDiary)
    @Delete
    suspend fun delete(record:MyDiary)
}
