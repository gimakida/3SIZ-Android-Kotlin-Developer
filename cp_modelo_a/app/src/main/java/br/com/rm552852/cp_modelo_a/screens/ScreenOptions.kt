package br.com.rm552852.cp_modelo_a.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.rm552852.cp_modelo_a.R

@Composable
fun ScreenOptions (

    onBack: () -> Unit,
    modifier: Modifier = Modifier
){
    val casas = listOf(
        Casa("Grifinória", R.drawable.gryffindor_2),
        Casa("Grifinória", R.drawable.gryffindor_2),
        Casa("Grifinória", R.drawable.gryffindor_2),
        
    )
}

