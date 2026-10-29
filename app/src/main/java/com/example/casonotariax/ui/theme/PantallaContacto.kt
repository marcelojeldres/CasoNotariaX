package com.example.casonotariax.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.casonotariax.ui.DarkNavy
import com.example.casonotariax.ui.SoftBlueBg
import com.example.casonotariax.ui.TextMuted
import com.example.casonotariax.ui.viewmodel.ContactoViewModel

@Composable
fun PantallaContacto(
    modifier: Modifier = Modifier,
    viewModel: ContactoViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Bloque 1: Título y descripción limpia
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(text = "ATENCIÓN NOTARIAL", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = TextMuted)
            Text(text = "Mesa de Ayuda", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = DarkNavy)
            Text(
                text = "¿Dudas sobre la plataforma o tus antecedentes? Escríbenos directamente.",
                fontSize = 13.sp,
                color = TextMuted
            )
        }

        // Bloque 2: Accesos rápidos en formato Chips horizontales
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = SoftBlueBg,
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(Icons.Default.Phone, contentDescription = null, tint = DarkNavy, modifier = Modifier.size(18.dp))
                    Column {
                        Text(text = "Llámanos", fontSize = 10.sp, color = TextMuted)
                        Text(text = "+56 2 2123 4567", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = DarkNavy)
                    }
                }
            }

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = SoftBlueBg,
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(Icons.Default.Email, contentDescription = null, tint = DarkNavy, modifier = Modifier.size(18.dp))
                    Column {
                        Text(text = "Escríbenos", fontSize = 10.sp, color = TextMuted)
                        Text(text = "soporte@notariax.cl", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = DarkNavy)
                    }
                }
            }
        }

        // Bloque 3: Formulario directo (Sin selector de trámite)
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(text = "Envía tu mensaje", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = DarkNavy)

                // Nombre
                OutlinedTextField(
                    value = state.nombre,
                    onValueChange = { viewModel.onNombreChange(it) },
                    label = { Text("Nombre completo") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    isError = state.errorNombre != null,
                    supportingText = { state.errorNombre?.let { Text(it, color = MaterialTheme.colorScheme.error) } },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // Correo
                OutlinedTextField(
                    value = state.correo,
                    onValueChange = { viewModel.onCorreoChange(it) },
                    label = { Text("Correo electrónico") },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = state.errorCorreo != null,
                    supportingText = { state.errorCorreo?.let { Text(it, color = MaterialTheme.colorScheme.error) } },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // Mensaje
                OutlinedTextField(
                    value = state.mensaje,
                    onValueChange = { viewModel.onMensajeChange(it) },
                    label = { Text("¿En qué te podemos ayudar?") },
                    isError = state.errorMensaje != null,
                    supportingText = {
                        state.errorMensaje?.let {
                            Text(it, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    minLines = 4,
                    maxLines = 6,
                    modifier = Modifier.fillMaxWidth()
                )

                // Botón
                Button(
                    onClick = { viewModel.enviarConsulta() },
                    enabled = state.esValido,
                    colors = ButtonDefaults.buttonColors(containerColor = DarkNavy),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Icon(Icons.Default.Send, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Enviar mensaje", fontWeight = FontWeight.Bold)
                }
            }
        }

        // Bloque 4: Aviso de horario
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(Icons.Default.AccessTime, contentDescription = null, tint = TextMuted, modifier = Modifier.size(16.dp))
            Text(
                text = "Horario notarial: Lunes a Viernes de 09:00 a 18:00 hrs.",
                fontSize = 12.sp,
                color = TextMuted
            )
        }

        // Animación de éxito
        AnimatedVisibility(
            visible = state.mensajeEnviado,
            enter = fadeIn() + slideInVertically()
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF2E7D32))
                    Text(
                        text = "Consulta enviada. Te responderemos al correo proporcionado.",
                        color = Color(0xFF2E7D32),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }

    // Modal de confirmación
    if (state.mostrarModalExito) {
        AlertDialog(
            onDismissRequest = { viewModel.cerrarModal() },
            title = { Text("Mensaje Recibido", fontWeight = FontWeight.Bold, color = DarkNavy) },
            text = {
                Text(
                    "Gracias ${state.nombre}, hemos recibido tu mensaje. Un funcionario notarial revisará tu consulta.",
                    color = TextMuted
                )
            },
            confirmButton = {
                Button(
                    onClick = { viewModel.cerrarModal() },
                    colors = ButtonDefaults.buttonColors(containerColor = DarkNavy)
                ) {
                    Text("Aceptar")
                }
            }
        )
    }
}