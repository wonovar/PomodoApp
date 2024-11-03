package com.example.pomodo.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pomodo.entity.Review

@Dao
interface ReviewDao {
    @Insert
    suspend fun insert(review: Review)

    @Update
    suspend fun update(review: Review)

    @Delete
    suspend fun delete(review: Review)

    @Query("SELECT * FROM review_table WHERE date = :date")
    fun getReviewByDate(date: String): LiveData<Review>
}