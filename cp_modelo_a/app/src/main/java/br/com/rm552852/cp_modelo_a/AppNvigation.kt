package br.com.rm552852.cp_modelo_a

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.rm552852.cp_modelo_a.screens.HomeScreen
import br.com.rm552852.cp_modelo_a.screens.ResultScreen
import br.com.rm552852.cp_modelo_a.screens.ScreenOptions

@Composable
fun AppNvigation(padding: Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "casa"
    ) {
        composable("casa") {
            HomeScreen(
                onNavigateToChoice = {
                    navController.navigate("choice")
                }
            )
        }

        composable("choice") {
            ScreenOptions(
                onCharacteristicSelected = { caracteristica->
                    navController.navigate("result/$caracteristica")
                }
            )
        }

        composable(
            route = "result/{caracteristica}",
            arguments = listOf(
                navArgument("caracteristica") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val caracteristica = backStackEntry.arguments?.getString("caracteristica") ?: ""
            ResultScreen(caracteristica = caracteristica)
        }
    }
}