package com.example.pokemon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
    navController =  navController,
        startDestination = "name"
    ){
        composable("name") {
            PlayerScreen(
                modifier = modifier,
                onStartGame = { name ->
                    navController.navigate("game/$name") // it é o string Unit
                }
            )
        }
        composable("game/{playerName}",
            arguments = listOf(
                navArgument("playerName"){
                    type = NavType.StringType
                }
            )
        ){backStackEntry ->
                val playerName = backStackEntry.arguments?.getString("playerName") ?: "Jogador" //se tiver playername vai pegar valor senao vai declarar desconhecido

                JokenPokemonScreen(
                    playerName = playerName,
                    onBack = { navController.popBackStack()}, // tira a tela da stack clica vai chamar navigation e fazer com que volta a tela anterior
                    modifier = modifier
                ) //implementa ação
        }

    }
}