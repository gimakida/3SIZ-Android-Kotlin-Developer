package br.com.rm552852.cp_modelo_a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.rm552852.cp_modelo_a.ui.theme.Cp_modelo_aTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cp_modelo_aTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor =  Color(0xFFFFF3E0) ) {
                    innerPadding ->  (Modifier.padding(innerPadding))

                }
            }
        }
    }
}

