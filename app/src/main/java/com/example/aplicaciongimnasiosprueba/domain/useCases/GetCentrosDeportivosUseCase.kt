package com.example.aplicaciongimnasiosprueba.domain.useCases

import com.example.aplicaciongimnasiosprueba.domain.models.CentrosDeportivos
import com.example.aplicaciongimnasiosprueba.domain.repository.CentrosDeportivosRepository

class GetCentrosDeportivosUseCase (
    private val centrosDeportivosRepository: CentrosDeportivosRepository
) {
    operator fun invoke(): CentrosDeportivos = centrosDeportivosRepository.getCentrosDeportivos()

}
