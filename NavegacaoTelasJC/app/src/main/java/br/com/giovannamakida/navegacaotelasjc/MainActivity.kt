package br.com.giovannamakida.navegacaotelasjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.giovannamakida.navegacaotelasjc.ui.screens.NumberAmountScreen
import br.com.giovannamakida.navegacaotelasjc.ui.screens.ResultScreen
import br.com.giovannamakida.navegacaotelasjc.ui.theme.NavegacaoTelasJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoTelasJCTheme {
                val navController =
                    rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "input"
                ) {
                    composable(route = "input") {
                        NumberAmountScreen(navController)
                    }
                    composable(route = "result") {
                        ResultScreen()


                    }
                }
            }
        }
    }
}


