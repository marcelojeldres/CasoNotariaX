package com.example.casonotariax.repository

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Shield
import com.example.casonotariax.model.AccesoRapido
import com.example.casonotariax.model.Metrica
import com.example.casonotariax.model.TramiteItem

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
    fun obtenerCatalogoTramites(): List<TramiteItem> {
        return listOf(
            TramiteItem(
                id = "poder",
                titulo = "Poder notarial",
                descripcion = "Representación legal para trámites específicos o generales.",
                precio = "S/ 120",
                tiempoEntrega = "24-48 h",
                icono = Icons.Default.Description
            ),
            TramiteItem(
                id = "empresa",
                titulo = "Constitución de empresa",
                descripcion = "Constituye tu empresa con acompañamiento notarial completo.",
                precio = "S/ 450",
                tiempoEntrega = "3-5 días",
                icono = Icons.Default.Business
            ),
            TramiteItem(
                id = "firma",
                titulo = "Legalización de firma",
                descripcion = "Certifica tu firma de manera presencial o digital.",
                precio = "S/ 45",
                tiempoEntrega = "El mismo día",
                icono = Icons.Default.Fingerprint
            ),
            TramiteItem(
                id = "escritura",
                titulo = "Escritura pública",
                descripcion = "Formaliza compraventas, poderes y contratos con seguridad.",
                precio = "S/ 280",
                tiempoEntrega = "2-4 días",
                icono = Icons.Default.Shield
            )
        )
    }
}