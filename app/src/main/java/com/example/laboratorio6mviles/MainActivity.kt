package com.example.laboratorio6mviles

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio6mviles.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation(activity = this)
        }
    }
}

@Composable
fun AppNavigation(activity: ComponentActivity) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

            DrawerContent(navController = navController, drawerState = drawerState, activity = activity)
        },
        content = {

            NavHost(navController = navController, startDestination = "splash") {
                composable("splash") { SplashScreen(navController) }
                composable("home") { HomeScreen(navController, drawerState, scope) }
                composable("savedRecipes") { SavedRecipesScreen(navController) }
                composable("settings") { SettingsScreen(navController) }
            }
        }
    )
}

@Composable
fun DrawerContent(navController: NavController, drawerState: DrawerState, activity: ComponentActivity) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF0000))
            .padding(16.dp)
    ) {
        Text("HOME", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                scope.launch { drawerState.close() }
                navController.navigate("home")
            })
        Spacer(modifier = Modifier.height(8.dp))

        // Opción para navegar a la actividad MainActivity2 usando Intent
        Text("PRIME RIB ROAST", color = Color.White, fontSize = 18.sp, modifier = Modifier.clickable {
            scope.launch { drawerState.close() }
            val intent = Intent(activity, MainActivity2::class.java)
            activity.startActivity(intent)
        })

        Spacer(modifier = Modifier.height(8.dp))

        // Opción para ir a (MainActivity3)
        Text("DETAILS COMPLETE", color = Color.White, fontSize = 18.sp, modifier = Modifier.clickable {
            scope.launch { drawerState.close() }
            // Llamada a MainActivity3 usando Intent
            val intent = Intent(activity, MainActivity3::class.java)
            activity.startActivity(intent)
        })

        Spacer(modifier = Modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("HARRY TRUMAN", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF0000)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.sombrerochef),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Chef Recipes",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }

    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, drawerState: DrawerState, scope: CoroutineScope) {

    // Cerrar el Drawer explícitamente cuando la pantalla se cargue
    LaunchedEffect(Unit) {
        scope.launch {
            drawerState.close() // Asegurarse de que el Drawer esté cerrado al inicio
        }
    }

    Column {
        TopAppBar(
            title = { Text("POPULAR RECIPES") },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color(0xFFFF0000),
                titleContentColor = Color.White
            ),
            // Ícono de menú para abrir el Drawer
            navigationIcon = {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.open() // Abrir el Drawer al presionar el ícono
                    }
                }) {
                    Icon(Icons.Default.Menu, contentDescription = null, tint = Color.White)
                }
            }
        )
        // Aquí va el contenido principal
        LazyColumn {
            item {
                RecipeCard(navController)
            }
        }
    }
}


@Composable
fun SavedRecipesScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("This is the Saved Recipes Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("This is the Settings Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun RecipeCard(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {},
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.lasagna),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Prime Rib Roast",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(8.dp)
            )
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
                Spacer(modifier = Modifier.width(4.dp))
                Text("4.5")
                Spacer(modifier = Modifier.width(8.dp))
                Text("685 SHARES")
                Spacer(modifier = Modifier.width(8.dp))
                Text("107 SAVES")
            }
        }
    }
}




