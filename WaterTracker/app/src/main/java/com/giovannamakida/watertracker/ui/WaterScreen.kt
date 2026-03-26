package com.giovannamakida.watertracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.giovannamakida.watertracker.ui.theme.BackgroundColor

@Composable
fun WaterScreen(
    waterUiState: WaterUiState,
    onDrink: () -> Unit,
    onRemove: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 24.dp, vertical =
                20.dp),
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {
    }
}