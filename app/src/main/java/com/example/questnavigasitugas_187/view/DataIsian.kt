package com.example.questnavigasitugas_187.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

    Scaffold(
        topBar = { TopAppBar(title = { Text("Formulir Pendaftaran") }) }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(isiRuang).fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "NAMA LENGKAP", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    OutlinedTextField(
                        value = namaLengkap, onValueChange = { namaLengkap = it },
                        label = { Text("Isikan nama lengkap") },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), singleLine = true
                    )

                    Text(text = "JENIS KELAMIN", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        RadioButtonOption(label = "Laki-laki", selected = selectedJenisKelamin == "Laki-laki", onClick = { selectedJenisKelamin = "Laki-laki" })
                        RadioButtonOption(label = "Perempuan", selected = selectedJenisKelamin == "Perempuan", onClick = { selectedJenisKelamin = "Perempuan" })
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "STATUS PERKAWINAN", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        RadioButtonOption(label = "Janda", selected = selectedStatusKawin == "Janda", onClick = { selectedStatusKawin = "Janda" })
                        RadioButtonOption(label = "Lajang", selected = selectedStatusKawin == "Lajang", onClick = { selectedStatusKawin = "Lajang" })
                        RadioButtonOption(label = "Duda", selected = selectedStatusKawin == "Duda", onClick = { selectedStatusKawin = "Duda" })
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "ALAMAT", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    OutlinedTextField(
                        value = alamat, onValueChange = { alamat = it },
                        label = { Text("Isikan alamat") },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), minLines = 3
                    )
                }
            }
        }
    }
}

@Composable
fun RadioButtonOption(label: String, selected: Boolean, onClick: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = label, modifier = Modifier.padding(start = 4.dp))
    }
}