package com.example.casonotariax.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.casonotariax.model.AccesoRapido
import com.example.casonotariax.viewmodel.InicioViewModel

val DarkNavy = Color(0xFF0F2843)
val LightBg = Color(0xFFF6F8FA)
val TextMuted = Color(0xFF6B7280)
val SoftBlueBg = Color(0xFFE8EEF5)
val CardBorder = Color(0xFFE2E8F0)

@Composable
fun PantallaInicio(
    viewModel: InicioViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = LightBg,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                tonalElevation = 8.dp
            ) {
                val menuItems = listOf(
                    Triple("Inicio", Icons.Default.Home, 0),
                    Triple("Trámites", Icons.Default.Description, 1),
                    Triple("Nosotros", Icons.Default.LocationOn, 2),
                    Triple("Contacto", Icons.Default.ChatBubbleOutline, 3),
                    Triple("Ingresar", Icons.Default.Person, 4)
                )

                menuItems.forEach { (titulo, icono, index) ->
                    NavigationBarItem(
                        selected = uiState.pestañaSeleccionada == index,
                        onClick = { viewModel.seleccionarPestaña(index) },
                        icon = { Icon(icono, contentDescription = titulo) },
                        label = { Text(titulo, fontSize = 11.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = DarkNavy,
                            indicatorColor = DarkNavy,
                            unselectedIconColor = TextMuted,
                            unselectedTextColor = TextMuted
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header: Logo y Chip Seguro
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
                        color = DarkNavy,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Description,
                            contentDescription = "Logo",
                            tint = Color.White,
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                    Text(
                        text = "NotariApp",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkNavy
                    )
                }

                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = Color(0xFFE8F5E9)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = Color(0xFF2E7D32),
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "Seguro",
                            color = Color(0xFF2E7D32),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Banner Principal
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = DarkNavy),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Surface(
                        color = Color.White.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "NOTARÍA DIGITAL",
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                    Text(
                        text = "Tu notaría,\nmás cerca de ti.",
                        color = Color.White,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 32.sp
                    )
                    Text(
                        text = "Trámites simples, seguros y con seguimiento desde tu celular.",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 13.sp
                    )
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Ver trámites y precios",
                            color = DarkNavy,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = DarkNavy,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            // Métricas
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    uiState.metricas.forEachIndexed { index, metrica ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = metrica.valor, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = DarkNavy)
                            Text(text = metrica.etiqueta, fontSize = 11.sp, color = TextMuted)
                        }
                        if (index < uiState.metricas.lastIndex) {
                            VerticalDivider(modifier = Modifier.height(30.dp), color = CardBorder)
                        }
                    }
                }
            }

            // Accesos Rápidos
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "ACCESOS RÁPIDOS",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMuted
                )
                Text(
                    text = "¿Qué necesitas?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkNavy
                )
            }

            val items = uiState.accesosRapidos
            for (i in items.indices step 2) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    BotonAccesoRapido(modifier = Modifier.weight(1f), item = items[i])
                    if (i + 1 < items.size) {
                        BotonAccesoRapido(modifier = Modifier.weight(1f), item = items[i + 1])
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }

            // Te llamamos
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = DarkNavy),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Color.White.copy(alpha = 0.15f),
                            modifier = Modifier.size(38.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Column {
                            Text(
                                text = "¿Necesitas orientación?",
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.7f)
                            )
                            Text(
                                text = uiState.mensajeLlamada,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    Button(
                        onClick = { viewModel.onSolicitarLlamadaClick() },
                        enabled = !uiState.llamadaSolicitada,
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White.copy(alpha = 0.2f),
                            disabledContainerColor = Color.White.copy(alpha = 0.08f)
                        )
                    ) {
                        Text(
                            text = if (uiState.llamadaSolicitada) "Enviado" else "Solicitar llamada",
                            fontSize = 11.sp,
                            color = Color.White
                        )
                    }
                }
            }

            // Aviso Seguridad
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VerifiedUser,
                        contentDescription = null,
                        tint = Color(0xFF2E7D32)
                    )
                    Column {
                        Text(
                            text = "Tu información está protegida",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = Color(0xFF1B5E20)
                        )
                        Text(
                            text = "Usamos cifrado y validación de identidad para cuidar tus datos.",
                            fontSize = 11.sp,
                            color = Color(0xFF2E7D32)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BotonAccesoRapido(
    modifier: Modifier = Modifier,
    item: AccesoRapido,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.clickable { onClick() },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = SoftBlueBg,
                    modifier = Modifier.size(34.dp)
                ) {
                    Icon(
                        imageVector = item.icono,
                        contentDescription = null,
                        tint = DarkNavy,
                        modifier = Modifier.padding(6.dp)
                    )
                }
                Column {
                    Text(text = item.titulo, fontWeight = FontWeight.Bold, fontSize = 12.sp, maxLines = 1)
                    Text(text = item.subtitulo, fontSize = 10.sp, color = TextMuted, maxLines = 1)
                }
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = TextMuted,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}