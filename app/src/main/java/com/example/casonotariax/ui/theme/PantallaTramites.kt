package com.example.casonotariax.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.casonotariax.model.TramiteItem

private val DarkNavy = Color(0xFF0F2843)
private val TextMuted = Color(0xFF6B7280)
private val SoftBlueBg = Color(0xFFE8EEF5)
private val CardBorder = Color(0xFFE2E8F0)

@Composable
fun PantallaTramites(
    tramites: List<TramiteItem>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "SERVICIOS NOTARIALES",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMuted
                )
                Text(
                    text = "Trámites y precios",
                    fontSize = 22.sp,
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

        Text(
            text = "Precios claros,\nsin sorpresas.",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = DarkNavy,
            lineHeight = 30.sp
        )
        Text(
            text = "Selecciona un trámite para solicitar información o iniciar una cotización.",
            fontSize = 13.sp,
            color = TextMuted
        )

        tramites.forEach { tramite ->
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = SoftBlueBg,
                            modifier = Modifier.size(40.dp)
                        ) {
                            Icon(
                                imageVector = tramite.icono,
                                contentDescription = null,
                                tint = DarkNavy,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Column {
                            Text(
                                text = tramite.titulo,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = DarkNavy
                            )
                            Spacer(Modifier.height(2.dp))
                            Text(
                                text = tramite.descripcion,
                                fontSize = 12.sp,
                                color = TextMuted
                            )
                        }
                    }

                    HorizontalDivider(color = CardBorder)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Desde", fontSize = 10.sp, color = TextMuted)
                            Text(
                                text = tramite.precio,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = DarkNavy
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Schedule,
                                contentDescription = null,
                                tint = TextMuted,
                                modifier = Modifier.size(14.dp)
                            )
                            Text(text = tramite.tiempoEntrega, fontSize = 11.sp, color = TextMuted)
                        }
                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .size(36.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(DarkNavy)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}