package com.example.aplicaciongimnasiosprueba.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.aplicaciongimnasiosprueba.ui.viewmodel.LoginViewModel
import kotlinx.coroutines.launch


/*@Composable
fun Login(navController: NavHostController) {
    Text(text= "Login Hola" )

}*/

@Composable
fun Login(viewModel: LoginViewModel,
          navController: NavController, //NavHostController
          modifier: Modifier = Modifier
) {
    //Text(text= "Login Hola" )

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC107)) // Fondo dorado
            .padding(16.dp)
    ) {
        LoginContent(Modifier.align(Alignment.Center),viewModel)
    }
}

@Composable
fun LoginContent (modifier: Modifier, viewModel: LoginViewModel ) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if (isLoading) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = Modifier) { //En esta columna que es para align en el centro hay q pasarlo por parametro dentro del Box arriba.
            HeaderImage(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            EmailField(email) {
                viewModel.onLoginChanged(
                    it,
                    password
                )
            } //cada vez que un usuario escribe en el emial, llama al viewmodel para comprobar si es correcto
            //EmailField()
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordField(password) { viewModel.onLoginChanged(email, it) }
            //PasswordField()
            Spacer(modifier = Modifier.padding(8.dp))
            ForgotPassword(Modifier.align(Alignment.End))
            Spacer(modifier = Modifier.padding(16.dp))
            //LoginButton(loginEnable){
            // coroutineScope.launch{
            //vieModel.onLoginSelected()}
            LoginButton(loginEnable){
                coroutineScope.launch {
                    viewModel.onLoginSelected()
                }
            }
        }
    }
}
@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit){
//fun LoginButton() {
    Button(
        onClick = {onLoginSelected() },
        //onClick = { },
        modifier =  Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3E2723),
            contentColor =  Color.White
        ), enabled = loginEnable
    ) {
        Text(text = "Iniciar Sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Olvidaste la Contraseña?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF3E2723)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onTextFieldChanged:(String) -> Unit){
//fun PasswordField() {
    //val password = remember{ mutableStateOf("") }
    TextField(
        value = password,
        onValueChange = {onTextFieldChanged(it)},
        //value = password.value,
        //onValueChange = {password.value = it},
        placeholder = { Text(text ="Contraseña") },
        modifier =  Modifier.fillMaxWidth(),
        //keyboardOptions = keyboardOptions(KeyboardType = keyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),  // Esto oculta el texto
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFDEDDDD)//Color vino

        )
        /*colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color(color = 0xFFDEDDDD),
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.Gray*/
    )
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmailField(email:String, onTextFieldChanged:(String) -> Unit){
//Tendría que borrar la val email cuando aplique la funcion de arriba
//fun EmailField() {
    //val email = remember{ mutableStateOf("") }

    TextField(
        //Principle single sort of true, los valores que pueden ser modificados en varios sitios,tienen que esta definidos en la parte mas alta.
        //y de ahi se lo va pasando a los componentes que lo necesiten.
        //value = email.value,
        value = email, onValueChange = {onTextFieldChanged(it)},
        //onValueChange = {email.value = it},//cada vez que se pulse va a llamar a onvaluechange
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        //keyboardOptions = KeyboardOptions(keyboardType = keyboardType.Email),
        singleLine = true,
        maxLines = 1,
        /*colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color(color = 0xFFDEDDDD),
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.Gray)*/
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = com.example.aplicaciongimnasiosprueba.R.drawable.lifting),
        contentDescription = "Imagen Login",
        modifier = modifier
    )
}



