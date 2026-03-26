package com.giovannamakida.watertracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.giovannamakida.watertracker.ui.InMemoryWaterRepository
import com.giovannamakida.watertracker.ui.WaterRepository
import com.giovannamakida.watertracker.ui.WaterScreen
import com.giovannamakida.watertracker.ui.WaterUiState
import com.giovannamakida.watertracker.ui.WaterViewModelFactory
import com.giovannamakida.watertracker.ui.theme.BackgroundColor
import com.giovannamakida.watertracker.ui.theme.PrimaryColor
import com.giovannamakida.watertracker.ui.theme.SecondaryTextColor
import com.giovannamakida.watertracker.ui.theme.WaterTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterTrackerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = BackgroundColor
                ) { innerPadding ->
                    //  val viewModel: WaterViewModel = viewModel()
                    val repository : WaterRepository = InMemoryWaterRepository()
                    val factory = WaterViewModelFactory(repository)
                    val viewModel: WaterViewModel = viewModel(factory = factory)
                    WaterScreen(
                        waterUiState = viewModel.uiState,
                        onDrink = viewModel::drinkOneCup,
                        onRemove = viewModel::removeOneCup,
                        onReset = viewModel::reset,
                        Modifier.padding(innerPadding)
                    )

                }
            }
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
                    Text(
                        text = "Beba Água💧",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = PrimaryColor
                    )
                    Text(
                        text = "HIDRATAÇÃO DIÁRIA",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp,
                        color = SecondaryTextColor
                    )
                    Spacer(modifier = Modifier.weight(1f))

                }
            }


            @Composable
            fun WaterIndicator(cupsDrunk: Int, goalCups: Int,) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Text(
                            text = "$cupsDrunk",
                            fontSize = 48.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = PrimaryColor,
                            modifier = Modifier.alignByBaseline()
                        )
                        Text(
                            text = "/$goalCups",
                            fontSize = 14.sp,
                            color = SecondaryTextColor,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.alignByBaseline()
                        )
                    }
                    Text(
                        text = if (cupsDrunk == 1) "COPO" else "COPOS",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = SecondaryTextColor
                    )
                }
            }
        }
    }
}
