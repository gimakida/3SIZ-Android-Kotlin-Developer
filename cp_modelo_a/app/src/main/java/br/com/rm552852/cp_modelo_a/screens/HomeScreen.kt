package br.com.rm552852.cp_modelo_a.screens

import android.icu.lang.UProperty
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rm552852.cp_modelo_a.HarryPotterLogo
import br.com.rm552852.cp_modelo_a.R
import br.com.rm552852.cp_modelo_a.ui.theme.Cp_modelo_aTheme

@Composable
fun HomeScreen(onNavigateToChoice: () -> Unit) {
   Column (
       modifier = Modifier
           .fillMaxSize()
           .padding(24.dp)
            .background(Color(0xFFB794DE)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

   ) {
       HarryPotterLogo( imgLogo = R.drawable.harry_potter_logo, label = "Logo harry Potter")

       Spacer(modifier = Modifier.height(32.dp).fillMaxWidth())

           Text("Seja bem-vindo(a) a casa de Hogwarts!  Descubra sua casa conforme sua personalidade.",
               fontSize = 22.sp,
               fontWeight = FontWeight.Bold,
               color = Color(0xFFFFD700),
               textAlign = TextAlign.Center,
               modifier = Modifier.padding(bottom = 48.dp)
           )
           Button(onClick = onNavigateToChoice) {
               Text(text = "Escolher característica", fontSize = 16.sp)
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
