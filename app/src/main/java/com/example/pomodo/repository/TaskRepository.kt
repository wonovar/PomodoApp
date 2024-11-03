package com.example.pomodo.repository

import androidx.lifecycle.LiveData
import com.example.pomodo.dao.TaskDao
import com.example.pomodo.entity.Task

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<Task>> = taskDao.getTasksByDate("") // 특정 날짜에 대한 작업 목록

    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }

    suspend fun update(task: Task) {
        taskDao.update(task)
    }

    suspend fun delete(task: Task) {
        taskDao.delete(task)
    }
}