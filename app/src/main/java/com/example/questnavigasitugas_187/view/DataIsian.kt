package com.example.questnavigasitugas_187.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataIsian(
    onSumbitSuccess: () -> Unit,
    onBerandaBtnClick: () -> Unit
) {
    var namaLengkap by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedJenisKelamin by remember { mutableStateOf("Laki-laki") }
    var selectedStatusKawin by remember { mutableStateOf("Lajang") }
    var showDialog by remember { mutableStateOf(false) }
}