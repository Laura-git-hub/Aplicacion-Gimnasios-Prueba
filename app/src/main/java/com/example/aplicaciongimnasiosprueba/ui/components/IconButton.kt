package com.example.aplicaciongimnasiosprueba.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun IconRedesButton(
    network: String, // Red de destino como Instagram, etc.
    iconId: Int,
    onClick: () -> Unit // Acción al hacer clic
) {
    val context = LocalContext.current

    IconButton(
        onClick = {
            onClick() // Ejecuta la acción cuando se hace clic
        },
        modifier = Modifier.size(48.dp)
    ) {
        Icon(

            imageVector = ImageVector.vectorResource(id = iconId),
            contentDescription = "",
            tint = Color.Unspecified
        )
    }
}
