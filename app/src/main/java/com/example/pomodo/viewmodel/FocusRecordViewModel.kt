package com.example.pomodo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pomodo.entity.FocusRecord
import com.example.pomodo.repository.FocusRecordRepository
import com.example.pomodo.database.PomodoDatabase
import kotlinx.coroutines.launch

class FocusRecordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FocusRecordRepository

    init {
        val focusRecordDao = PomodoDatabase.getDatabase(application).focusRecordDao()
        repository = FocusRecordRepository(focusRecordDao)
    }

    fun insert(record: FocusRecord) = viewModelScope.launch {
        repository.insert(record)
    }

    fun getRecordByDate(date: String): LiveData<FocusRecord> {
        return repository.getRecordByDate(date)
    }
}