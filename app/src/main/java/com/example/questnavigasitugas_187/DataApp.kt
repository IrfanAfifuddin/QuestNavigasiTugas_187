package com.example.questnavigasitugas_187

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    Splash,
    Formulirku,
    List
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Splash.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigasi.Splash.name) {
                Halaman1(
                    onMasukClick = {
                        navController.navigate(Navigasi.Formulirku.name)
                    }
                )
            }

            composable(route = Navigasi.Formulirku.name) {
                DataIsian(
                    onSumbitSuccess = {
                        navController.navigate(route = Navigasi.List.name)
                    },
                    onBerandaBtnClick = {
                        navController.navigate(route = Navigasi.Splash.name) {
                            popUpTo(Navigasi.Splash.name) { inclusive = true }
                        }
                    }
                )
            }

            composable(route = Navigasi.List.name) {
                ListPesertaScreen(
                    onBerandaClick = {
                        navController.navigate(route = Navigasi.Splash.name) {
                            popUpTo(Navigasi.Splash.name) { inclusive = true }
                        }
                    },
                    onFormulirClick = {
                        navController.navigate(route = Navigasi.Formulirku.name)
                    }
                )
            }
        }
    }
}