package com.example.casonotariax.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ContactoUiState(
    val nombre: String = "",
    val correo: String = "",
    val mensaje: String = "",
    val errorNombre: String? = null,
    val errorCorreo: String? = null,
    val errorMensaje: String? = null,
    val esValido: Boolean = false,
    val mostrarModalExito: Boolean = false,
    val mensajeEnviado: Boolean = false
)

class ContactoViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ContactoUiState())
    val uiState: StateFlow<ContactoUiState> = _uiState.asStateFlow()

    fun onNombreChange(nuevoNombre: String) {
        val error = if (nuevoNombre.trim().length < 3) "Ingresa al menos 3 caracteres" else null
        _uiState.value = _uiState.value.copy(nombre = nuevoNombre, errorNombre = error)
        validar()
    }

    fun onCorreoChange(nuevoCorreo: String) {
        val error = if (!nuevoCorreo.contains("@") || !nuevoCorreo.contains(".")) "Correo inválido" else null
        _uiState.value = _uiState.value.copy(correo = nuevoCorreo, errorCorreo = error)
        validar()
    }

    fun onMensajeChange(nuevoMensaje: String) {
        val error = if (nuevoMensaje.trim().length < 10) "Escribe al menos 10 caracteres" else null
        _uiState.value = _uiState.value.copy(mensaje = nuevoMensaje, errorMensaje = error)
        validar()
    }

    private fun validar() {
        val s = _uiState.value
        val valido = s.nombre.trim().length >= 3 &&
                s.errorNombre == null &&
                s.correo.contains("@") &&
                s.errorCorreo == null &&
                s.mensaje.trim().length >= 10 &&
                s.errorMensaje == null

        _uiState.value = _uiState.value.copy(esValido = valido)
    }

    fun enviarConsulta() {
        if (_uiState.value.esValido) {
            _uiState.value = _uiState.value.copy(mostrarModalExito = true)
        }
    }

    fun cerrarModal() {
        _uiState.value = ContactoUiState(
            mensajeEnviado = true,
            mostrarModalExito = false
        )
    }
}