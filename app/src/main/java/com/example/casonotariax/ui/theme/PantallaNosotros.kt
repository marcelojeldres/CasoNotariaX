package com.example.casonotariax.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.casonotariax.model.CaracteristicaNosotros
import com.example.casonotariax.model.SedeItem
import com.example.casonotariax.ui.DarkNavy
import com.example.casonotariax.ui.SoftBlueBg
import com.example.casonotariax.ui.TextMuted

@Composable
fun PantallaNosotros(
    caracteristicas: List<CaracteristicaNosotros>,
    sedes: List<SedeItem>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Cabecera: "CONÓCENOS" y título con chip de Seguros
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "CONÓCENOS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = TextMuted)
                Text(text = "Nosotros y sedes", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = DarkNavy)
            }

            Surface(shape = RoundedCornerShape(20.dp), color = Color(0xFFE8F5E9)) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF2E7D32), modifier = Modifier.size(14.dp))
                    Text(text = "Seguro", color = Color(0xFF2E7D32), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Imagen principal con tarjeta superpuesta de "15 años de experiencia"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
        ) {
            // Imagen de oficina / fondo simulado
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "INFRAESTRUCTURA DIGITAL",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White.copy(alpha = 0.7f)
                        )
                        Text(
                            text = "Simplificando la gestión\nnotarial en línea.",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            lineHeight = 26.sp
                        )
                        Text(
                            text = "Conectando a personas y empresas con notarios de forma segura.",
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }

            // Tarjeta superpuesta de experiencia (esquina inferior derecha)
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = DarkNavy,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp)
                    .width(130.dp)
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "15", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Column {
                        Text(text = "años de", fontSize = 10.sp, color = Color.White.copy(alpha = 0.7f))
                        Text(text = "experiencia", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }

        // Quiénes somos: Títulos y descripción
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(text = "QUIÉNES SOMOS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = TextMuted)
            Text(
                text = "Experiencia jurídica,\natención humana.",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = DarkNavy,
                lineHeight = 30.sp
            )
            Text(
                text = "Combinamos tradición notarial y tecnología para que cada trámite sea claro, ágil y confiable.",
                fontSize = 13.sp,
                color = TextMuted
            )
        }

        // Fila de Características (Seguridad jurídica / Acompañamiento real)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            caracteristicas.forEach { car ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = SoftBlueBg,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = car.icono,
                                contentDescription = null,
                                tint = DarkNavy,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Text(text = car.titulo, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = DarkNavy)
                        Text(text = car.descripcion, fontSize = 11.sp, color = TextMuted, lineHeight = 14.sp)
                    }
                }
            }
        }

        // Sección de Ubicaciones / Mapa
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "NUESTRAS UBICACIONES", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = TextMuted)
                    Text(text = "Visítanos", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkNavy)
                }
                Text(text = "3 sedes en Lima", fontSize = 11.sp, color = TextMuted)
            }

            // Tarjeta del Mapa simulado
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = SoftBlueBg),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    // Aquí puedes renderizar un mapa real con Google Maps Compose si deseas más adelante
                    Icon(imageVector = Icons.Default.Place, contentDescription = null, tint = DarkNavy, modifier = Modifier.size(48.dp))
                }
            }
        }

        // Lista de Sedes
        sedes.forEach { sede ->
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = SoftBlueBg,
                            modifier = Modifier.size(42.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Place,
                                contentDescription = null,
                                tint = DarkNavy,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(text = sede.tipoEtiqueta, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = TextMuted)
                            Text(text = sede.nombre, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = DarkNavy)
                            Text(text = sede.direccion, fontSize = 12.sp, color = TextMuted)
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                modifier = Modifier.padding(top = 2.dp)
                            ) {
                                Icon(imageVector = Icons.Default.Schedule, contentDescription = null, tint = TextMuted, modifier = Modifier.size(12.dp))
                                Text(text = sede.horario, fontSize = 11.sp, color = TextMuted)
                            }
                        }
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = TextMuted,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}