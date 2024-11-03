package com.example.pomodo.repository

import androidx.lifecycle.LiveData
import com.example.pomodo.dao.ReviewDao
import com.example.pomodo.entity.Review

class ReviewRepository(private val reviewDao: ReviewDao) {
    suspend fun insert(review: Review) {
        reviewDao.insert(review)
    }

    fun getReviewByDate(date: String): LiveData<Review> {
        return reviewDao.getReviewByDate(date)
    }
}