package br.com.giovannamakida.navegacaotelasjc.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.giovannamakida.navegacaotelasjc.ui.theme.NavegacaoTelasJCTheme

@Composable
fun NumberAmountScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment =
            Alignment.CenterHorizontally,
        verticalArrangement =
            Arrangement.Center

    ) {
        Text(
        text = "Gerador de Loteria",
        style =
            MaterialTheme.typography.headlineMedium
    )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate("result")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Gerar números")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NumberAmountScreenPreview(){
    NavegacaoTelasJCTheme {
        NumberAmountScreen(rememberNavController())
    }
}