package com.example.aplicaciongimnasiosprueba.ui.models

import com.example.aplicaciongimnasiosprueba.R
import com.example.aplicaciongimnasiosprueba.domain.models.CentrosDeportivos

//Representa los datos de los cetros deportivos

data class CentrosDeportivosUIModel (
    val icon1: Int,
    val icon2: Int,
    val redsocial_icono: Int,
    val tituloBienvenida: String,
    val nameCentroDeportivo1: String,
    val nameCentroDeportivo2: String,
    val nameCentroDeportivo3: String,
    val imageUrl1: Int,
    val imageUrl2: Int,
    val imageUrl3: Int,

)

fun CentrosDeportivos.toUI() = CentrosDeportivosUIModel(
    icon1 = icon1, icon2 = icon2, redsocial_icono = redsocial_icono, tituloBienvenida = tituloBienvenida,
    nameCentroDeportivo1 = nameCentroDeportivo1, nameCentroDeportivo2 = nameCentroDeportivo2, nameCentroDeportivo3 = nameCentroDeportivo3, imageUrl1 = imageUrl1,
    imageUrl2 = imageUrl2, imageUrl3 = imageUrl3
)

/*data class CentrosDeportivosUIModel(
    val icon1: Int?,
    val icon2: Int?,
    val redsocial_icono: Int?,
    val tituloBienvenida: String,
    val nameCentroDeportivo1: String,
    val nameCentroDeportivo2: String,
    val nameCentroDeportivo3: String,
    val imageUrl1: Int?,
    val imageUrl2: Int?,
    )


/*fun CentrosDeportivos.toUI() = CentrosDeportivosUIModel(
    icon1 = icon1.takeIf { it != 0 } ?: R.drawable.baseline_person_24,  // Si icon1 es 0, usa el valor predeterminado
    icon2 = icon2.takeIf { it != 0 } ?: R.drawable.baseline_search_24,  // Si icon2 es 0, usa el valor predeterminado
    redsocial_icono = redsocial_icono.takeIf { it != 0 } ?: R.drawable.instagram_icono,  // Si redsocial_icono es 0, usa el valor predeterminado
    tituloBienvenida = tituloBienvenida.takeIf { it.isNotEmpty() } ?: "Bienvenidos al Centro Deportivo",  // Si el título está vacío, usa un valor predeterminado
    nameCentroDeportivo1 = nameCentroDeportivo1.takeIf { it.isNotEmpty() } ?: "Centro Deportivo 1",  // Si el nombre está vacío, usa un valor predeterminado
    nameCentroDeportivo2 = nameCentroDeportivo2.takeIf { it.isNotEmpty() } ?: "Centro Deportivo 2",  // Similar para el nombre
    nameCentroDeportivo3 = nameCentroDeportivo3.takeIf { it.isNotEmpty() } ?: "Centro Deportivo 3",  // Similar para el nombre
    imageUrl1 = imageUrl1.takeIf { it != 0 } ?: R.drawable.gimnasio_madrid,  // Si imageUrl1 es 0, usa el valor predeterminado
    imageUrl2 = imageUrl2.takeIf { it != 0 } ?: R.drawable.gimnasio_barcelona,  // Similar para imageUrl2
    //imageUrl3 = imageUrl3.takeIf { it != 0 } ?: R.drawable.gimnasio_sevilla,  // Similar para imageUrl3
)

*/