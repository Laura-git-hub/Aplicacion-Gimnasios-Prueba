package com.example.aplicaciongimnasiosprueba.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicaciongimnasiosprueba.domain.useCases.GetCentrosDeportivosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CentrosDeportivosViewModel (

    private val getCentrosDeportivosUseCase: GetCentrosDeportivosUseCase,
    ) : ViewModel() {

    private val _uiState: MutableStateFlow<CentrosDeportivosState> =
        MutableStateFlow(CentrosDeportivosState())

    /**
     * Estado público e inmutable de la UI.
     *
     * La UI solo tiene acceso a `uiState` (de tipo `StateFlow`), evitando modificaciones directas.
     */
    val uiState: StateFlow<CentrosDeportivosState> = _uiState

    init {
        fetchCentrosDeportivosDetails()
    }

    private fun fetchCentrosDeportivosDetails() = viewModelScope.launch {
        // Mostrar el indicador de carga mientras se obtienen los datos, en nuestro caso simulado 0 segundos
        _uiState.update { state -> state.copy(showLoadingIndicator = true) }

        // Obtener el usuario llamando al caso de uso, falta mejorar aplicando corutinas.
        val centrosdeportivos = getCentrosDeportivosUseCase()

        // Actualizar el estado de la UI con los datos de los CentrosDeportivos transformandolo en un CDUIModel

        //NO ME FUNCIONA .toUI() HABRIA QUE CREAR
        // UNA FUCNION EN CDUIModel.kt

        _uiState.update { state ->
            state.copy(
                //centrosdeportivos = centrosdeportivos.toUI(),
                showLoadingIndicator = false
            )
        }
    }
}


