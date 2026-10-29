package com.example.casonotariax.repository

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.VerifiedUser
import com.example.casonotariax.model.AccesoRapido
import com.example.casonotariax.model.CaracteristicaNosotros
import com.example.casonotariax.model.Metrica
import com.example.casonotariax.model.SedeItem
import com.example.casonotariax.model.TramiteItem

class NotariaRepository {

    fun obtenerMetricas(): List<Metrica> {
        return listOf(
            Metrica(valor = "+12 mil", etiqueta = "Trámites"),
            Metrica(valor = "98%", etiqueta = "Satisfacción"),
            Metrica(valor = "15 años", etiqueta = "Experiencia")
        )
    }

    fun obtenerAccesosRapidos(): List<AccesoRapido> {
        return listOf(
            AccesoRapido("tramites", "Trámites y precios", "Consulta opciones", Icons.Default.Description),
            AccesoRapido("asesor", "Hablar con un ase...", "Estamos para ayudarte", Icons.Default.ChatBubbleOutline),
            AccesoRapido("sedes", "Nuestras sedes", "Encuentra la más cercana", Icons.Default.Place),
            AccesoRapido("mis_tramites", "Mis trámites", "Seguimiento en línea", Icons.Default.Person)
        )
    }

    fun solicitarLlamada(): Boolean {
        return true
    }
    fun obtenerCatalogoTramites(): List<TramiteItem> {
        return listOf(
            TramiteItem(
                id = "poder",
                titulo = "Poder notarial",
                descripcion = "Representación legal para trámites específicos o generales.",
                descripcionDetallada = "El poder notarial es un documento legal mediante el cual una persona (el poderdante) autoriza a otra (el apoderado) para actuar en su nombre en gestiones bancarias, administrativas, judiciales o comerciales. Es fundamental redactar los alcances y límites de las facultades otorgadas.",
                precio = "$7.000 clp",
                tiempoEntrega = "24-48 h",
                icono = Icons.Default.Description
            ),
            TramiteItem(
                id = "empresa",
                titulo = "Constitución de empresa",
                descripcion = "Constituye tu empresa con acompañamiento notarial completo.",
                descripcionDetallada = "Inicia tu negocio formalmente mediante la elaboración de la escritura pública de constitución de sociedad (SAC, SRL, EIRL). Incluye la asesoría en la redacción de estatutos sociales, búsqueda mercantil y la firma ante notario para su posterior inscripción registral.",
                precio = "$17.000 clp",
                tiempoEntrega = "3-5 días",
                icono = Icons.Default.Business
            ),
            TramiteItem(
                id = "firma",
                titulo = "Legalización de firma",
                descripcion = "Certifica tu firma de manera presencial o digital.",
                descripcionDetallada = "Acto mediante el cual el notario da fe de que una firma ha sido puesta en su presencia, comprobando la identidad del firmante. Es un requisito indispensable para contratos privados, cartas notariales, autorizaciones de viaje y otros documentos comerciales.",
                precio = "$4.000 clp",
                tiempoEntrega = "El mismo día",
                icono = Icons.Default.Fingerprint
            ),
            TramiteItem(
                id = "escritura",
                titulo = "Escritura pública",
                descripcion = "Formaliza compraventas, poderes y contratos con seguridad.",
                descripcionDetallada = "Documento matriz autorizado por el notario que contiene actos jurídicos de trascendencia (como transferencia de bienes inmuebles, hipotecas o testamentos). Ofrece máxima seguridad jurídica y fe pública sobre las declaraciones de los otorgantes.",
                precio = "$26.000 clp",
                tiempoEntrega = "2-4 días",
                icono = Icons.Default.Shield
            )
        )
    }

    fun obtenerCaracteristicasNosotros(): List<CaracteristicaNosotros>{
        return listOf(
            CaracteristicaNosotros(
                titulo = "Seguridad Juridica",
                descripcion = "Documentos revisador por especialistas",
                icono = Icons.Default.VerifiedUser
            ),
            CaracteristicaNosotros(
                titulo = "Acompañamiento real",
                descripcion = "Asesores disponibles en cada paso",
                icono = Icons.Default.Person
            )
        )
    }
    fun obtenerSedes(): List<SedeItem>{
        return listOf(
            SedeItem(
                id = "san_isidro",
                tipoEtiqueta = "SEDE PRINCIPAL",
                nombre = "Sede San Isidro",
                direccion = "Av. Javier Prado Oeste 420",
                horario = "Lun-Vie - 8:30 a 18:00"
            ),
            SedeItem(
                id = "miraflores",
                tipoEtiqueta = "HORARIO EXTENDIDO",
                nombre = "Sede Miraflores",
                direccion = "Av. José Larco 812",
                horario = "Lun-Sáb - 9:00 a 17:00"
            ),
            SedeItem(
                id = "la_molina",
                tipoEtiqueta = "ESTACIONAMIENTO",
                nombre = "Sede La Molina",
                direccion = "Av. Raúl Ferrero 1280",
                horario = "Lun-Vie - 9:00 a 17:30"
            )
        )
    }
}