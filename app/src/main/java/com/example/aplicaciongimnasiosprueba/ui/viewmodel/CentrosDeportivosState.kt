package com.example.aplicaciongimnasiosprueba.ui.viewmodel

import com.example.aplicaciongimnasiosprueba.ui.models.CentrosDeportivosUIModel

data class CentrosDeportivosState (
    val showLoadingIndicator: Boolean = false, // Indica si la UI debe mostrar un spinner de carga.

    val centrosdeportivos: CentrosDeportivosUIModel = CentrosDeportivosUIModel(
        nameCentroDeportivo1= "",
        nameCentroDeportivo2 = "",
        nameCentroDeportivo3 = "",
        icon1 = 0,
        icon2 = 0,
        imageUrl1 = 0,
        imageUrl2 = 0,
        imageUrl3 = 0,
        redsocial_icono = 0,
        tituloBienvenida = "",
    )
)
