package com.example.casonotariax.viewmodel

import androidx.lifecycle.ViewModel
import com.example.casonotariax.model.AccesoRapido
import com.example.casonotariax.model.CaracteristicaNosotros
import com.example.casonotariax.model.Metrica
import com.example.casonotariax.model.SedeItem
import com.example.casonotariax.model.TramiteItem
import com.example.casonotariax.repository.NotariaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class InicioUiState(
    val metricas: List<Metrica> = emptyList(),
    val accesosRapidos: List<AccesoRapido> = emptyList(),
    val catalogoTramites: List<TramiteItem> = emptyList(),
    val caracteristicasNosotros: List<CaracteristicaNosotros> = emptyList(),
    val sedes: List<SedeItem> = emptyList(),
    val estaAutenticado: Boolean= false,
    val correoUsuario: String = "",
    val esModoRegistro: Boolean = false,
    val nombreUsuario: String = "",
    val correosRegistrados: List<String> = listOf(""),
    val errorLogin: String? = null,
    val tramiteSeleccionado: TramiteItem? = null,
    val mostrarDetalleTramite: Boolean = false,
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
                accesosRapidos = repository.obtenerAccesosRapidos(),
                catalogoTramites = repository.obtenerCatalogoTramites(),
                caracteristicasNosotros = repository.obtenerCaracteristicasNosotros(),
                sedes = repository.obtenerSedes()
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

    fun seleccionarTramiteParaDetalle(tramite: TramiteItem){
        _uiState.update{
            it.copy(
                tramiteSeleccionado = tramite,
                mostrarDetalleTramite = true
            )
        }
    }

    fun volverAListaTramites(){
        _uiState.update {
            it.copy(
                tramiteSeleccionado = null,
                mostrarDetalleTramite = false
            )
        }
    }

    fun solicitarDocumentoActual(): Boolean{
        _uiState.update { currentState ->
            currentState.copy(
                mensajeLlamada = "¡Trámite solicitado con éxito!",
                mostrarDetalleTramite = false
            )
        }
        return true
    }

    fun cambiarModoRegistro(esRegistro: Boolean){
        _uiState.update {it.copy(esModoRegistro = esRegistro)}
    }

    fun registrarUsuario(correo: String, pass: String, nombre: String) {
        if (correo.isNotBlank() && pass.isNotBlank() && nombre.isNotBlank()) {
            _uiState.update { currentState ->
                currentState.copy(
                    estaAutenticado = true,
                    correoUsuario = correo,
                    nombreUsuario = nombre,
                    correosRegistrados = currentState.correosRegistrados + correo,
                    errorLogin = null
                )
            }
        } else {
            _uiState.update { it.copy(errorLogin = "Por favor completa todos los campos.") }
        }
    }
    fun iniciarSesion(correo: String, pass: String) {
        if (correo.isNotBlank() && pass.isNotBlank()) {
            val ui = _uiState.value
            if (ui.correosRegistrados.contains(correo)) {
                val nombreExtraido = correo.substringBefore("@").replaceFirstChar { it.uppercase() }
                _uiState.update {
                    it.copy(
                        estaAutenticado = true,
                        correoUsuario = correo,
                        nombreUsuario = nombreExtraido,
                        errorLogin = null
                    )
                }
            } else {
                _uiState.update {
                    it.copy(errorLogin = "Este correo no esta registrado. Registrate primero")
                }
            }
        } else {
            _uiState.update { it.copy(errorLogin = "Ingresa correo y contraseña") }
        }
    }

    fun cerrarSesion() {
        _uiState.update {
            it.copy(
                estaAutenticado = false,
                correoUsuario = "",
                esModoRegistro = false
            )
        }
    }

}