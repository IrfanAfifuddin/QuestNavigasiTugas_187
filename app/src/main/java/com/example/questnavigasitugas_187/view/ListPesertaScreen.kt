package com.example.questnavigasitugas_187.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

data class Peserta (
    val namaLengkap: String,
    val jenisKelamin: String,
    val statusKawin: String,
    val alamat: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPesertaScreen(
    onBerandaClick: () -> Unit,
    onFormulirClick: () -> Unit
) {
    val dataPeserta = listOf(
        Peserta("Putra", "Laki-laki", "Lajang", "Bantul"),
        Peserta("Asha", "Perempuan", "Lajang", "Genuk")
    )

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.list_daftar_peserta)) }) },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = onBerandaClick) { Text(stringResource(R.string.btn_beranda)) }
                Button(onClick = onFormulirClick) { Text(stringResource(R.string.btn_formulir)) }
            }
        }
    ) { isiRuang ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(isiRuang).padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(dataPeserta) { peserta ->
                ParticipantCard(peserta = peserta)
            }
        }
    }
}