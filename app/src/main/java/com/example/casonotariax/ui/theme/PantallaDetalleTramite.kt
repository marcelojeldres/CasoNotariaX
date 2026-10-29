package com.example.casonotariax.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.FontScaling
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.casonotariax.model.TramiteItem
import com.example.casonotariax.ui.CardBorder
import com.example.casonotariax.ui.DarkNavy
import com.example.casonotariax.ui.SoftBlueBg
import com.example.casonotariax.ui.TextMuted


@Composable
fun PantallaDetalleTramite(
    tramite: TramiteItem,
    onVolverClick: ()-> Unit,
    onSolicitarClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            IconButton(onClick = onVolverClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = DarkNavy
                )
            }
            Text(
                text= "Detalle del tramite",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = DarkNavy
            )
        }

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = SoftBlueBg,
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = tramite.icono,
                            contentDescription = null,
                            tint = DarkNavy,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Column{
                        Text(
                            text = tramite.titulo,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = DarkNavy
                        )
                        Text(
                            text = "Codigo ID: ${tramite.id}",
                            fontSize = 12.sp,
                            color = TextMuted
                        )
                    }
                }
                Divider(color = CardBorder)
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = "Descripción detallada",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = DarkNavy
                    )
                    Text(
                        text = tramite.descripcionDetallada, // Muestra el texto completo del repositorio
                        fontSize = 13.sp,
                        color = TextMuted,
                        lineHeight = 18.sp
                    )
                }
                Divider(color = CardBorder)
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(text = "Descripcion", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = DarkNavy)
                    Text(text = tramite.descripcion, fontSize = 13.sp, color = TextMuted)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column {
                        Text(text = "Costo estimado", fontSize = 12.sp, color = TextMuted)
                        Text(text = tramite.precio, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = DarkNavy)
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(text = "Tiempo de entrega", fontSize = 12.sp, color = TextMuted)
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Icon(imageVector = Icons.Default.Schedule, contentDescription = null, tint = TextMuted, modifier = Modifier.size(14.dp))
                            Text(text = tramite.tiempoEntrega, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = DarkNavy)
                        }
                    }
                }
            }
        }
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Requisitos para este trámite", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = DarkNavy)
                tramite.requisitos.forEach { req ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF2E7D32), modifier = Modifier.size(16.dp))
                        Text(text = req, fontSize = 13.sp, color = TextMuted)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onSolicitarClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkNavy)
        ) {
            Text(
                text = "Solicitar documento / Iniciar trámite",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}

















