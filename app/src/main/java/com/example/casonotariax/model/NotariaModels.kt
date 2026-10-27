package com.example.casonotariax.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Metrica(
    val valor: String,
    val etiqueta: String
)

data class AccesoRapido(
    val id: String,
    val titulo: String,
    val subtitulo: String,
    val icono: ImageVector
)

data class TramiteItem(
    val id: String,
    val titulo: String,
    val descripcion: String,
    val precio: String,
    val tiempoEntrega: String,
    val icono: ImageVector
)