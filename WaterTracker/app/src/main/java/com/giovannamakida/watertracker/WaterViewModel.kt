package com.giovannamakida.watertracker

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovannamakida.watertracker.ui.WaterRepository
import com.giovannamakida.watertracker.ui.WaterUiState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WaterViewModel(
    val repository: WaterRepository
) : ViewModel() {
    var uiState by mutableStateOf(WaterUiState())
        private set

    init {
        observeCups()
    }

    private fun observeCups(){
        viewModelScope.launch{
            repository.getCupsDrunk().collectLatest { cups ->
                uiState = uiState.copy(cupsDrunk = cups)
            }
        }
    }

    fun drinkOneCup() {
        if (uiState.cupsDrunk < uiState.goalCups) {
            viewModelScope.launch {
                repository.saveCupsDrunk(uiState.cupsDrunk +1)
            }
        }
    }
    fun removeOneCup() {
        if (uiState.cupsDrunk > 0) {
            viewModelScope.launch {
                repository.saveCupsDrunk(uiState.cupsDrunk +1)
            }
        }
    }
    fun reset() {
        viewModelScope.launch {
            repository.clear()
        }
    }
}