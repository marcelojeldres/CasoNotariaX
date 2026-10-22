package com.example.casonotariax.viewmodel

import androidx.lifecycle.ViewModel
import com.example.casonotariax.model.AccesoRapido
import com.example.casonotariax.model.Metrica
import com.example.casonotariax.repository.NotariaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class InicioUiState(
    val metricas: List<Metrica> = emptyList(),
    val accesosRapidos: List<AccesoRapido> = emptyList(),
    val llamadaSolicitada: Boolean = false,
    val mensajeLlamada: String = "Te llamamos sin costo",
    val pestañaSeleccionada: Int = 0
)

class InicioViewModel(
    private val repository: NotariaRepository = NotariaRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(InicioUiState())
    val uiState: StateFlow<InicioUiState> = _uiState.asStateFlow()

    init {
        cargarDatos()
    }

    private fun cargarDatos() {
        _uiState.update {
            it.copy(
                metricas = repository.obtenerMetricas(),
                accesosRapidos = repository.obtenerAccesosRapidos()
            )
        }
    }

    fun seleccionarPestaña(indice: Int) {
        _uiState.update { it.copy(pestañaSeleccionada = indice) }
    }

    fun onSolicitarLlamadaClick() {
        if (repository.solicitarLlamada()) {
            _uiState.update {
                it.copy(
                    llamadaSolicitada = true,
                    mensajeLlamada = "¡Solicitud recibida! Te llamaremos"
                )
            }
        }
    }
}