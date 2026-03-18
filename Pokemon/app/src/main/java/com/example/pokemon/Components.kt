package com.example.pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonLogo() {
    Image(
        painter = painterResource(R.drawable.logo_pokemon),
        contentDescription = "Logo do Pokemon",
        modifier = Modifier
            .height(150.dp)
            .padding(16.dp)
    )
}

@Composable
fun BattleArena(
    player: Pokemon?,
    computer: Pokemon?,
    result: String,
    playerName: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PokemonCard(player, playerName, mirror = true)
            PokemonCard(computer, "Computador", mirror = false)
        }

        if (result.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = result,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
    }
}

@Composable
fun PokemonCardItem(name: String, imageRes: Int, mirror: Boolean = false) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = name,
        modifier = Modifier
            .size(180.dp)
            .graphicsLayer { scaleX = if (mirror) -1f else 1f }
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
}

@Composable
fun PokemonCardItemDefault() {
    Image(
        painter = painterResource(R.drawable.pokeball_unselected),
        contentDescription = "-",
        modifier = Modifier.size(120.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun PokemonCard(pokemon: Pokemon?, playerName: String, mirror: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (pokemon == null) {
            PokemonCardItemDefault()
            Text(playerName)
        } else {
            PokemonCardItem(pokemon.name, pokemon.imageRes, mirror)
            Text(playerName)
        }
    }
}

@Composable
fun PokemonOption(
    pokemon: Pokemon,
    selected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable { onSelected() }
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(
                if (selected)
                    R.drawable.pokeball_selected
                else
                    R.drawable.pokeball_unselected
            ),
            contentDescription = pokemon.name,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(pokemon.name, fontSize = 16.sp)
    }
}