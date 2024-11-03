package com.example.pomodo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "focus_record_table")
data class FocusRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "date") val date: String, // YYYY-MM-DD 형식으로 날짜 저장
    @ColumnInfo(name = "total_focus_time") val totalFocusTime: Int // 분 단위로 저장
)