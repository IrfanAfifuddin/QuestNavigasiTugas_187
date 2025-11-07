package com.example.questnavigasitugas_187.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_187.R

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
        Peserta("Apip", "Laki-laki", "Lajang", "Yogyakarta"),
        Peserta("Kayla", "Perempuan", "Lajang", "Malang")
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

@Composable
fun ParticipantCard(peserta: Peserta) {
    Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(2.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                DataRowItem(label = stringResource(R.string.nama_lengkap), value = peserta.namaLengkap, modifier = Modifier.weight(1f))
                DataRowItem(label = stringResource(R.string.jenis_kelamin), value = peserta.jenisKelamin, modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                DataRowItem(label = stringResource(R.string.status_kawin), value = peserta.statusKawin, modifier = Modifier.weight(1f))
                DataRowItem(label = stringResource(R.string.alamat), value = peserta.alamat, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun DataRowItem(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(label.uppercase(), fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    }
}