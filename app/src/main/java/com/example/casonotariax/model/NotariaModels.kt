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
    val descripcionDetallada: String = "Este trámite requiere la validación de antecedentes y la presencia de las partes involucradas según la normativa vigente.",
    val precio: String,
    val tiempoEntrega: String,
    val icono: ImageVector,
    val requisitos: List<String> = listOf("copia de documento de identidad", "formulario completado")
)

data class CaracteristicaNosotros(
    val titulo: String,
    val descripcion: String,
    val icono: ImageVector
)

data class SedeItem(
    val id: String,
    val tipoEtiqueta: String,
    val nombre: String,
    val direccion: String,
    val horario: String
)