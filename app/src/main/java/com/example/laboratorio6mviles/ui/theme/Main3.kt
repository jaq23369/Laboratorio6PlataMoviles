package com.example.laboratorio6mviles.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio6mviles.R

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeDetailsCompleteScreen()
        }
    }
}

@Composable
fun RecipeDetailsCompleteScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.3f)), // Fondo translúcido
        contentAlignment = Alignment.Center
    ) {
        CompleteCard()
    }
}

@Composable
fun CompleteCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            // Botón para cerrar la tarjeta (puede agregar funcionalidad más adelante)
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                IconButton(onClick = { /* Lógica para cerrar la tarjeta */ }) {
                    Icon(Icons.Default.Close, contentDescription = null, tint = Color.Black)
                }
            }

            // Texto principal "You Did It!"
            Text(
                text = "YOU DID IT!",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF1E88E5) // Color azul fuerte
            )

            // Texto secundario
            Text(
                text = "Let your friends know about it",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Íconos de redes sociales
            SocialMediaIcons()

            // Sección de "Leave a review"
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Leave a review",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Gray,
            )
            RatingStars()
        }
    }
}
@Composable
fun SocialMediaIcons() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Íconos de redes sociales (debes agregar imágenes en drawable)
        Icon(
            painter = painterResource(id = R.drawable.ic_google), // Reemplaza con tu imagen
            contentDescription = "Google+",
            tint = Color.Red,
            modifier = Modifier.size(32.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_facebook), // Reemplaza con tu imagen
            contentDescription = "Facebook",
            tint = Color.Blue,
            modifier = Modifier.size(32.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_instagram), // Reemplaza con tu imagen
            contentDescription = "Instagram",
            tint = Color.Magenta,
            modifier = Modifier.size(32.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_twitter), // Reemplaza con tu imagen
            contentDescription = "Twitter",
            tint = Color.Cyan,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun RatingStars() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        // Puedes reemplazar esto con íconos de estrellas para la calificación
        repeat(5) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star), // Reemplaza con tu imagen de estrella
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
