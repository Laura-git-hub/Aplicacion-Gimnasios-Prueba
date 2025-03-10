package com.example.aplicaciongimnasiosprueba.data.repository

import com.example.aplicaciongimnasiosprueba.R
import com.example.aplicaciongimnasiosprueba.domain.models.CentrosDeportivos
import com.example.aplicaciongimnasiosprueba.domain.repository.CentrosDeportivosRepository

class FakeCentrosDeportivosDataRepository : CentrosDeportivosRepository {
    private val mockUserData = CentrosDeportivos(
        icon1 = R.drawable.baseline_person_24,
        icon2 = R.drawable.baseline_search_24,
        redsocial_icono = R.drawable.instagram_icono,
        tituloBienvenida = "Hola, Bienvenid@ a Tu Centro Deprotivo",
        nameCentroDeportivo1 = "V-Fit Madrid",
        nameCentroDeportivo2 = "V-Fit Barcelona",
        nameCentroDeportivo3 = "V-Fit Sevilla",
        imageUrl1 = R.drawable.gimnasio_madrid,
        imageUrl2 =R.drawable.gimnasio_barcelona ,
        imageUrl3 =R.drawable.gimnasio_sevilla,
    )
    override fun getCentrosDeportivos(): CentrosDeportivos = mockUserData
}