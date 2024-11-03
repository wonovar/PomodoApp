package com.example.pomodo.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pomodo.entity.Task

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM task_table WHERE date = :date")
    fun getTasksByDate(date: String): LiveData<List<Task>>
}