package com.giovannamakida.taskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.giovannamakida.taskapp.data.local.db.AppDatabase
import com.giovannamakida.taskapp.data.local.repository.TaskRepository
import com.giovannamakida.taskapp.presentation.screen.TaskScreen
import com.giovannamakida.taskapp.presentation.screen.TaskViewModel
import com.giovannamakida.taskapp.ui.theme.TaskAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "task_db"
        ).build()
        val repository = TaskRepository(db.taskDao())
        val viewModel = TaskViewModel(repository)
        setContent {
            TaskAppTheme {
                TaskScreen(viewModel)
            }
        }
    }
}
