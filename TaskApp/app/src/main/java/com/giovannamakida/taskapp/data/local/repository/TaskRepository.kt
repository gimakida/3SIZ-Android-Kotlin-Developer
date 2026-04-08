package com.giovannamakida.taskapp.data.local.repository

import com.giovannamakida.taskapp.data.local.dao.TaskDao
import com.giovannamakida.taskapp.data.local.entity.Task

class TaskRepository(
    private val dao: TaskDao
) {
    val tasks = dao.getAll()
    suspend fun insert(task: Task) {
        dao.insert(task)
    }
    suspend fun delete(task: Task) {
        dao.delete(task)
    }
    suspend fun clearAll() {
        dao.clearAll()
    }
}