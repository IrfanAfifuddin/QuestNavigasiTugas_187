package com.example.questnavigasitugas_187

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

enum class Navigasi {
    Splash,
    Formulirku,
    List
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
)