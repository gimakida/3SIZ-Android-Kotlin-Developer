package com.example.pokemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
    navController =  navController,
        startDestination = "name"
    ){
        composable("name"){
            PlayerScreen(){
                navController.navigate("game/$it") // it é o string Unit
            }
        }
        composable("game/{playerName}",
            arguments = listOf(
                navArgument("playerName"){
                    type = NavType.StringType
                }
            )
        ){backStackEntry ->
                val playerName = backStackEntry.arguments?.getString("playerName") ?: "Desconhecido" //se tiver playername vai pegar valor senao vai declarar desconhecido
                JokenPokemonScreen(playerName) { //implementa ação
                    navController.popBackStack() // tira a tela da stack clica vai chamar navigation e fazer com que volta a tela anterior
                }
            }

    }
}