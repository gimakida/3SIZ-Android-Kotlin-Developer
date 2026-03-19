package br.com.rm552852.cp_modelo_a.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rm552852.cp_modelo_a.R


data class Casa(
    val name: String,
    val message: String,
    val imageRes: Int,
    val color: Color
)

@Composable
fun ResultScreen(caracteristica: String) {

    val casa = when (caracteristica) {
        "Coragem" -> Casa(
            name = "Grifinória",
            message = "Você é corajoso e destemido! A Grifinória é o seu lar.",
            imageRes = R.drawable.gryffindor_2,
            color = Color(0xFF740001)
        )
        "Inteligência" -> Casa(
            name = "Corvinal",
            message = "Você é inteligente e criativo! A Corvinal celebra sua mente.",
            imageRes = R.drawable.ravenclaw_2,
            color = Color(0xFF0E1A40)
        )
        "Lealdade" -> Casa(
            name = "Lufa-Lufa",
            message = "Você é leal e dedicado! A Lufa-Lufa valoriza seu coração.",
            imageRes = R.drawable.hufflepuff_2,
            color = Color(0xFFECB939)
        )
        "Ambição" -> Casa(
            name = "Sonserina",
            message = "Você é ambicioso e astuto! A Sonserina reconhece seu poder.",
            imageRes = R.drawable.slytherin_2,
            color = Color(0xFF1A472A)
        )
        else -> Casa(
            name = "Desconhecida",
            message = "Casa não encontrada.",
            imageRes = R.drawable.hogwarts_2,
            color = Color.Gray
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(casa.color)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sua casa é:",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = casa.name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFD700),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Image(
            painter = painterResource(id = casa.imageRes),
            contentDescription = casa.name,
            modifier = Modifier
                .size(180.dp)
                .padding(bottom = 24.dp)
        )

        Text(
            text = casa.message,
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}