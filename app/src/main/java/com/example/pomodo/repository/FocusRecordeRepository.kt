package com.example.pomodo.repository

import androidx.lifecycle.LiveData
import com.example.pomodo.dao.FocusRecordDao
import com.example.pomodo.entity.FocusRecord

class FocusRecordRepository(private val focusRecordDao: FocusRecordDao) {
    suspend fun insert(record: FocusRecord) {
        focusRecordDao.insert(record)
    }

    fun getRecordByDate(date: String): LiveData<FocusRecord> {
        return focusRecordDao.getRecordByDate(date)
    }
}