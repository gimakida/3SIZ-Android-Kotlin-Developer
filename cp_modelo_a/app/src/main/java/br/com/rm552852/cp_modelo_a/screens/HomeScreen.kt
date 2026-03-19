package br.com.rm552852.cp_modelo_a.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rm552852.cp_modelo_a.HarryPotterLogo
import br.com.rm552852.cp_modelo_a.R
import br.com.rm552852.cp_modelo_a.ui.theme.Cp_modelo_aTheme

@Composable
fun HomeScreen(
  onStartGame: (String) -> Unit,
  modifier: Modifier = Modifier
) {
   Column (
       modifier = Modifier
           .fillMaxSize()
           .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
   ) {
       HarryPotterLogo( imgLogo = R.drawable.harry_potter_logo, label = "Logo harry Potter")

       Spacer(modifier = Modifier.height(32.dp).fillMaxWidth())

       Text(" Seja bem-vindo(a) a casa de Hogwarts!  Descubra sua casa conforme sua personalidade.")

       Button(modifier = Modifier.fillMaxWidth(),
           onClick = {

           }
       ) {
           Text("Escolher característica")
       }
   }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    Cp_modelo_aTheme(){
        HomeScreen({},)
    }
}
