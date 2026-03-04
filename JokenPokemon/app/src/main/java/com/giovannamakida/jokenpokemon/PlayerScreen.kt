package com.giovannamakida.jokenpokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable
fun  PokemonScreen (){
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row(verticalAlignment =  Alignment.CenterVertically){
            Image(
                painter = painterResource(id = R.drawable.logo_pokemon ),
                contentDescription = stringResource(R.string.player_name),
                modifier = Modifier.size(64.dp)
            )

        }

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = quantity
        )

    }
}