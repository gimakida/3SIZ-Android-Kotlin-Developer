package com.giovannamakida.taskapp.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovannamakida.taskapp.data.local.entity.Task
import com.giovannamakida.taskapp.data.local.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(
    private val repository: TaskRepository
) : ViewModel() {
    val tasks = repository.tasks
    fun addTask(title: String) {
        viewModelScope.launch {
            repository.insert(Task(title = title))
        }
    }
    fun removeTask(task: Task) {
        viewModelScope.launch {
            repository.delete(task)
        }
    }
    fun clearAllTasks() {
        viewModelScope.launch {
            repository.clearAll()
        }
    }
}