package com.example.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JokenPokemonScreen(
    playerName: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pokemons = listOf(
        Pokemon("Charmander", R.drawable.charmander),
        Pokemon("Bulbasaur", R.drawable.bulbassaur),
        Pokemon("Squirtle", R.drawable.squirtle)
    )

    var playerChoice by remember { mutableStateOf<Pokemon?>(null) }
    var computerChoice by remember { mutableStateOf<Pokemon?>(null) }
    var result by remember { mutableStateOf("") }

    fun play(selected: Pokemon) {
        val compChoice = pokemons.random()
        val battleResult = when {
            selected.name == compChoice.name -> "Empate!"
            (selected.name == "Charmander" && compChoice.name == "Bulbassaur") ||
                    (selected.name == "Bulbassaur" && compChoice.name == "Squirtle") ||
                    (selected.name == "Squirtle" && compChoice.name == "Charmander") -> "Você venceu!"

            else -> "Você perdeu!"
        }
        playerChoice = selected
        computerChoice = compChoice
        result = battleResult
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Trocar Jogador",
                    tint = Color.Black
                )
            }
        }

        PokemonLogo()

        Spacer(modifier = Modifier.weight(1f))
        BattleArena(playerChoice, computerChoice, result, playerName)
        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .border(2.dp, Color.LightGray, RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .background(
                    Color.White.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Text(
                "Faça sua jogada de mestre",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                pokemons.forEach { p ->
                    PokemonOption(
                        pokemon = p,
                        selected = playerChoice == p,
                        onSelected = { play(p) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }


        }

    }
}
