package com.example.casonotariax.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.casonotariax.ui.DarkNavy
import com.example.casonotariax.ui.TextMuted
import com.example.casonotariax.viewmodel.InicioUiState

@Composable
fun PantallaPerfil(
    uiState: InicioUiState,
    onLoginClick: (String, String) -> Unit,
    onRegistroClick: (String, String, String) -> Unit,
    onCambiarModo: (Boolean) -> Unit,
    onCerrarSesion: () -> Unit,
    onIrATramites: () -> Unit,
    modifier: Modifier = Modifier
) {
    var correoInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var nombreInput by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkNavy)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Cabecera superior
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color.White,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VerifiedUser,
                        contentDescription = "Logo",
                        tint = DarkNavy,
                        modifier = Modifier.padding(6.dp)
                    )
                }
                Text(text = "NotariApp", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(text = "PORTAL SEGURO", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White.copy(alpha = 0.7f))
            Text(
                text = if (uiState.estaAutenticado) "¡Bienvenido de nuevo!" else "Gestiona tus trámites\ndesde un solo lugar.",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = 30.sp
            )
            Text(
                text = if (uiState.estaAutenticado) "Tu sesión se mantiene activa de forma segura." else "Consulta estados, recibe alertas y firma documentos de forma segura.",
                fontSize = 12.sp,
                color = Color.White.copy(alpha = 0.8f)
            )
        }

        Card(
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (uiState.estaAutenticado) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(50.dp),
                            color = SoftBlueBg,
                            modifier = Modifier.size(72.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = DarkNavy,
                                modifier = Modifier.padding(18.dp)
                            )
                        }
                        Text(
                            text = uiState.nombreUsuario,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = DarkNavy
                        )
                        Text(
                            text = uiState.correoUsuario,
                            fontSize = 13.sp,
                            color = TextMuted
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = onIrATramites,
                            modifier = Modifier.fillMaxWidth().height(48.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = DarkNavy)
                        ) {
                            Text(text = "Ir a trámites", fontWeight = FontWeight.Bold, color = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                        }

                        OutlinedButton(
                            onClick = onCerrarSesion,
                            modifier = Modifier.fillMaxWidth().height(48.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(text = "Cerrar sesión", fontWeight = FontWeight.Bold, color = Color.Red)
                        }
                    }
                } else {
                    Text(
                        text = if (uiState.esModoRegistro) "Crear una nueva cuenta" else "Iniciar sesión",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkNavy
                    )
                    Text(
                        text = if (uiState.esModoRegistro) "Regístrate con tu nombre, correo y contraseña." else "Ingresa con tus datos registrados.",
                        fontSize = 12.sp,
                        color = TextMuted
                    )

                    if (uiState.esModoRegistro) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(text = "Nombre completo", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = TextMuted)
                            OutlinedTextField(
                                value = nombreInput,
                                onValueChange = { nombreInput = it },
                                placeholder = { Text("Tu nombre", fontSize = 13.sp) },
                                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = TextMuted) },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedTextColor = DarkNavy,
                                    unfocusedTextColor = DarkNavy,
                                    focusedBorderColor = DarkNavy,
                                    unfocusedBorderColor = TextMuted,
                                    focusedPlaceholderColor = TextMuted,
                                    unfocusedPlaceholderColor = TextMuted
                                ),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true
                            )
                        }
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(text = "Correo electrónico", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = TextMuted)
                        OutlinedTextField(
                            value = correoInput,
                            onValueChange = { correoInput = it },
                            placeholder = { Text("nombre@correo.com", fontSize = 13.sp) },
                            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null, tint = TextMuted) },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = DarkNavy,
                                unfocusedTextColor = DarkNavy,
                                focusedBorderColor = DarkNavy,
                                unfocusedBorderColor = TextMuted,
                                focusedPlaceholderColor = TextMuted,
                                unfocusedPlaceholderColor = TextMuted
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(text = "Contraseña", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = TextMuted)
                        OutlinedTextField(
                            value = passwordInput,
                            onValueChange = { passwordInput = it },
                            placeholder = { Text("Tu contraseña", fontSize = 13.sp) },
                            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = TextMuted) },
                            visualTransformation = PasswordVisualTransformation(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = DarkNavy,
                                unfocusedTextColor = DarkNavy,
                                focusedBorderColor = DarkNavy,
                                unfocusedBorderColor = TextMuted,
                                focusedPlaceholderColor = TextMuted,
                                unfocusedPlaceholderColor = TextMuted
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )
                    }
                    if (uiState.errorLogin != null) {
                        Text(
                            text = uiState.errorLogin,
                            color = Color.Red,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Button(
                        onClick = {
                            if (uiState.esModoRegistro) {
                                onRegistroClick(correoInput, passwordInput, nombreInput)
                            } else {
                                onLoginClick(correoInput, passwordInput)
                            }
                        },
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = DarkNavy)
                    ) {
                        Text(
                            text = if (uiState.esModoRegistro) "Registrarse de forma segura →" else "Ingresar de forma segura →",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (uiState.esModoRegistro) "¿Ya tienes una cuenta?" else "¿No tienes cuenta?",
                            fontSize = 12.sp,
                            color = TextMuted
                        )
                        TextButton(onClick = { onCambiarModo(!uiState.esModoRegistro) }) {
                            Text(
                                text = if (uiState.esModoRegistro) "Inicia sesión" else "Regístrate aquí",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = DarkNavy
                            )
                        }
                    }
                }
            }
        }
    }
}