package com.example.aplicaciongimnasiosprueba.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.aplicaciongimnasiosprueba.ui.viewmodel.CentrosDeportivosState
import com.example.aplicaciongimnasiosprueba.ui.viewmodel.CentrosDeportivosViewModel

@Composable
fun CentrosDeportivosScreen(
    viewModel: CentrosDeportivosViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    CentrosDeportivosScreenContent(uiState, navController, modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CentrosDeportivosScreenContent(
    uiState: CentrosDeportivosState,
    navController: NavController,
    modifier: Modifier
) {
    if (uiState.showLoadingIndicator) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80000000))
                .padding(16.dp)
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {},
                    actions = {
                        IconButton(onClick = { /* Acción de usuario */ }) {
                            Image(
                                painter = painterResource(id = uiState.centrosdeportivos.icon1),
                                contentDescription = "Icono de usuario",
                                modifier = Modifier.size(26.dp)
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* Acción búsqueda */ }) {
                            Image(
                                painter = painterResource(id = uiState.centrosdeportivos.icon2),
                                contentDescription = "Icono de búsqueda",
                                modifier = Modifier.size(26.dp)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFC107)
                    )
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = Color(0xFFFFC107),
                    contentColor = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /* Acción Instagram */ }) {
                            Image(
                                painter = painterResource(id = uiState.centrosdeportivos.redsocial_icono),
                                contentDescription = "Icono de Instagram",
                                modifier = Modifier.size(60.dp)
                            )
                        }
                    }
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF8F5F0))
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Text(
                            uiState.centrosdeportivos.tituloBienvenida,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            fontStyle = FontStyle.Italic,
                            color = Color(0xFF3E2723),
                            modifier = Modifier.padding(bottom = 32.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .padding(top = 120.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        item {
                            CentroDeportivoItem(
                                title = uiState.centrosdeportivos.nameCentroDeportivo1,
                                imageResId = uiState.centrosdeportivos.imageUrl1,
                                navController = navController
                            )
                        }
                        item {
                            CentroDeportivoItem(
                                title = uiState.centrosdeportivos.nameCentroDeportivo2,
                                imageResId = uiState.centrosdeportivos.imageUrl2,
                                navController = navController
                            )
                        }
                        item {
                            CentroDeportivoItem(
                                title = uiState.centrosdeportivos.nameCentroDeportivo3,
                                imageResId = uiState.centrosdeportivos.imageUrl3,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CentroDeportivoItem(title: String, imageResId: Int, navController: NavController) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("login") }
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            Text(
                text = title,
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = Color(0xFF3E2723),
                modifier = Modifier.padding(end = 8.dp)
            )
        }
        item {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Imagen de $title",
                modifier = Modifier.size(220.dp)
            )
        }
    }
}
