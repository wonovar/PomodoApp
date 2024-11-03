package com.example.pomodo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "review_table")
data class Review(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "date") val date: String, // YYYY-MM-DD 형식으로 날짜 저장
    @ColumnInfo(name = "emoji") val emoji: String // 사용자가 선택한 이모지
)