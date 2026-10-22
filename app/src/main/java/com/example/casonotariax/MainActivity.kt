package com.example.casonotariax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.casonotariax.ui.PantallaInicio
import com.example.casonotariax.ui.theme.CasoNotariaXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CasoNotariaXTheme {
                PantallaInicio()
            }
        }
    }
}