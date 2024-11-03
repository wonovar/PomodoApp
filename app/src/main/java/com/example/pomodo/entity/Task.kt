package com.example.pomodo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "date") val date: String, // YYYY-MM-DD 형식으로 날짜 저장
    @ColumnInfo(name = "task_name") val taskName: String,
    @ColumnInfo(name = "completion_status") val completionStatus: String // "○", "△", "✕"
)