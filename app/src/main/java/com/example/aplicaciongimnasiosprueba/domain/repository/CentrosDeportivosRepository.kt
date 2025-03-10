package com.example.aplicaciongimnasiosprueba.domain.repository

import com.example.aplicaciongimnasiosprueba.domain.models.CentrosDeportivos

interface CentrosDeportivosRepository {
    fun getCentrosDeportivos(): CentrosDeportivos
    //TODO: Faltan otras funciones para completar el comportamiento en un caso real
}