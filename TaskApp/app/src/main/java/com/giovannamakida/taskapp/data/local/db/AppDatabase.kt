package com.giovannamakida.taskapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.giovannamakida.taskapp.data.local.dao.TaskDao
import com.giovannamakida.taskapp.data.local.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}