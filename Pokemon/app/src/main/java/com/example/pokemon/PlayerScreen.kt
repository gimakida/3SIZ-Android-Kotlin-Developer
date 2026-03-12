package com.example.pokemon

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemon.ui.theme.PokemonTheme

@Composable
fun PlayerScreen(
    onStartGame:(String) -> Unit
){
    var name by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment =  Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        PokemonLogo(imgLogo = R.drawable.logo_pokemon, label = "Logo Pokemon")

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it},
            label = { Text("Digite seu nome") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {onStartGame(name)},
            enabled = name.isNotEmpty(), //se o nome for diferente do vazio, vai habilitar true ou false
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text("Iniciar Batalha")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun  PlayerScreenPreview(){
    PokemonTheme {
        PlayerScreen (){  }// passa o tema do aplicativo e a tela
    }
}