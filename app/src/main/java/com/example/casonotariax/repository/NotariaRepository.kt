package com.example.casonotariax.repository

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import com.example.casonotariax.model.AccesoRapido
import com.example.casonotariax.model.Metrica

class NotariaRepository {

    fun obtenerMetricas(): List<Metrica> {
        return listOf(
            Metrica(valor = "+12 mil", etiqueta = "Trámites"),
            Metrica(valor = "98%", etiqueta = "Satisfacción"),
            Metrica(valor = "15 años", etiqueta = "Experiencia")
        )
    }

    fun obtenerAccesosRapidos(): List<AccesoRapido> {
        return listOf(
            AccesoRapido("tramites", "Trámites y precios", "Consulta opciones", Icons.Default.Description),
            AccesoRapido("asesor", "Hablar con un ase...", "Estamos para ayudarte", Icons.Default.ChatBubbleOutline),
            AccesoRapido("sedes", "Nuestras sedes", "Encuentra la más cercana", Icons.Default.Place),
            AccesoRapido("mis_tramites", "Mis trámites", "Seguimiento en línea", Icons.Default.Person)
        )
    }

    fun solicitarLlamada(): Boolean {
        return true
    }
}