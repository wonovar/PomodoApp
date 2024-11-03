package com.example.pomodo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pomodo.dao.TaskDao
import com.example.pomodo.dao.FocusRecordDao
import com.example.pomodo.dao.ReviewDao
import com.example.pomodo.entity.Task
import com.example.pomodo.entity.FocusRecord
import com.example.pomodo.entity.Review

@Database(entities = [Task::class, FocusRecord::class, Review::class], version = 1, exportSchema = false)
abstract class PomodoDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun focusRecordDao(): FocusRecordDao
    abstract fun reviewDao(): ReviewDao

    companion object {
        @Volatile
        private var INSTANCE: PomodoDatabase? = null

        fun getDatabase(context: Context): PomodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PomodoDatabase::class.java,
                    "pomodo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}