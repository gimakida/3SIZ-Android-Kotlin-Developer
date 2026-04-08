package com.giovannamakida.taskapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.giovannamakida.taskapp.data.local.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)
    @Delete
    suspend fun delete(task: Task)
    @Query("SELECT * FROM Tasks ORDER BY id DESC")
    fun getAll(): Flow<List<Task>>
    @Query("DELETE FROM Tasks")
    suspend fun clearAll()
}