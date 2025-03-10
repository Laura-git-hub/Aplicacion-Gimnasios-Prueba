package com.example.aplicaciongimnasiosprueba.ui.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class LoginViewModel : ViewModel(){

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email //LiveData: mutables estados en las vistas

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    // Inicialización de userDao
    //private val userDao: UserDao = AppDatabase.getDatabase(application).userDao()

    fun onLoginChanged(email: String, password:String){
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    suspend fun onLoginSelected(){
        _isLoading.value = true
        delay(4000)
        //val user = User(email = email.value ?: "", password = password.value ?: "")
        /* // Inserta el usuario en la base de datos
         withContext(Dispatchers.IO) {
             try {
                 userDao.insert(user)
             } catch (e: Exception) {
                 // Maneja el error (puedes mostrar un mensaje en la UI si ocurre un error)
             }
                 e.printStackTrace()
         }*/
        //Cambia el estado de carga
        _isLoading.value = false
    }
}
