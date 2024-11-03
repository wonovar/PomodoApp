package com.example.pomodo.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pomodo.entity.FocusRecord

@Dao
interface FocusRecordDao {
    @Insert
    suspend fun insert(record: FocusRecord)

    @Update
    suspend fun update(record: FocusRecord)

    @Delete
    suspend fun delete(record: FocusRecord)

    @Query("SELECT * FROM focus_record_table WHERE date = :date")
    fun getRecordByDate(date: String): LiveData<FocusRecord>
}