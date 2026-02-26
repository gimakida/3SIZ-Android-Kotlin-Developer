package br.com.giovannamakida.navegacaotelasjc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.giovannamakida.navegacaotelasjc.ui.screens.NumberAmountScreen
import br.com.giovannamakida.navegacaotelasjc.ui.screens.ResultScreen

@Composable
fun AppNavGraph(navController:
                NavHostController
) {
    NavHost(navController = navController,
        startDestination = "input") {
        composable(route = "input") {
            NumberAmountScreen {
                navController.navigate("result")
            }
        }
        composable(route = "result") {
            ResultScreen()
        }

    }
}