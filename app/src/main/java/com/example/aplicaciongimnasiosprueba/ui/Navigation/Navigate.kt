package com.example.aplicaciongimnasiosprueba.ui.Navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aplicaciongimnasiosprueba.data.repository.FakeCentrosDeportivosDataRepository
import com.example.aplicaciongimnasiosprueba.domain.useCases.GetCentrosDeportivosUseCase
import com.example.aplicaciongimnasiosprueba.ui.screen.CentrosDeportivosScreen
import com.example.aplicaciongimnasiosprueba.ui.screens.Login
import com.example.aplicaciongimnasiosprueba.ui.viewmodel.CentrosDeportivosViewModel
import com.example.aplicaciongimnasiosprueba.ui.viewmodel.LoginViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun Navigate(navController: NavHostController, padding: Modifier) {

    NavHost(navController = navController, startDestination = "Centro Deportivo"){
        composable("Centro Deportivo"){CentrosDeportivosScreen(navController = navController, viewModel = CentrosDeportivosViewModel(
            getCentrosDeportivosUseCase = GetCentrosDeportivosUseCase(
                centrosDeportivosRepository = FakeCentrosDeportivosDataRepository()
            )
        )
        )
        }
        composable("Login"){
            val loginViewModel: LoginViewModel = viewModel()
            Login(viewModel = loginViewModel, navController = navController)
        }
    }
}
