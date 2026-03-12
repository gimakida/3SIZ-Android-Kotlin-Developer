package com.example.pokemon

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun JokenPokemonScreen(
    playerName:String,
    onBackPressed: () ->Unit
){
    Scaffold{ innerPadding ->

        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
                ){
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Trocar jogador",
                        tint = Color.Black // troca a cor
                    )
                }
            }
            Text(playerName)
        }

    }

}