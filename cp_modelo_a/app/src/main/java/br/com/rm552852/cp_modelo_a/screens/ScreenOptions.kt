package br.com.rm552852.cp_modelo_a.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rm552852.cp_modelo_a.R

@Composable
fun ScreenOptions(onCharacteristicSelected: (String) -> Unit) {

    val caracteristica = listOf("Coragem", "Inteligência", "Lealdade", "Ambição")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A0A2E))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Qual é sua principal característica?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFD700),
            modifier = Modifier.padding(bottom = 40.dp)
        )

        caracteristica.forEach { caracteristica ->
            Button(
                onClick = { onCharacteristicSelected(caracteristica) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = caracteristica, fontSize = 16.sp)
            }
        }
    }
}

