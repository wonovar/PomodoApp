package com.example.pomodo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pomodo.entity.Review
import com.example.pomodo.repository.ReviewRepository
import com.example.pomodo.database.PomodoDatabase
import kotlinx.coroutines.launch

class ReviewViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ReviewRepository

    init {
        val reviewDao = PomodoDatabase.getDatabase(application).reviewDao()
        repository = ReviewRepository(reviewDao)
    }

    fun insert(review: Review) = viewModelScope.launch {
        repository.insert(review)
    }

    fun getReviewByDate(date: String): LiveData<Review> {
        return repository.getReviewByDate(date)
    }
}