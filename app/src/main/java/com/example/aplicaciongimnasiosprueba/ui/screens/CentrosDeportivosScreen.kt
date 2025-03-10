package com.example.aplicaciongimnasiosprueba.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
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

import com.example.aplicaciongimnasiosprueba.ui.components.IconRedesButton

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
                        Icon(
                            imageVector = ImageVector.vectorResource(uiState.centrosdeportivos.icon1),
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { /* Acción búsqueda */ },
                            modifier = Modifier.size(26.dp)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(uiState.centrosdeportivos.icon2),
                                contentDescription = "Icono de búsqueda",
                                tint = Color.Unspecified
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
                        IconRedesButton(
                            network = "Instagram", // Corregir según los parámetros que pasas
                            iconId = uiState.centrosdeportivos.redsocial_icono,
                            onClick = { /* Acción Instagram */ }
                        )
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
                // Aquí se ha reestructurado la disposición para que `LazyColumn` sea la raíz
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(top = 50.dp)
                ) {
                    // Título de bienvenida
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

                    // Elementos de los centros deportivos con LazyColumn
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

@Composable
fun CentroDeportivoItem(title: String, imageResId: Int, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { navController.navigate("login") }
    ) {
        // Aquí se utiliza `LazyRow` para mostrar el título y la imagen juntos de manera eficiente
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
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
}
