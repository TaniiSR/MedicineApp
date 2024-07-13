package com.task.medicineapp.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.task.medicineapp.data.dtos.Problem
import com.task.medicineapp.presentation.view.MainUIState
import com.task.medicineapp.utils.getGreetings

@Composable
fun MedicineListScreen(
    uiState: MainUIState,
    onMedicineClick: (medicine: Problem) -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize())
    { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            item {
                Column {
                    Text(
                        modifier = Modifier
                            .padding(20.dp)
                            .align(Alignment.CenterHorizontally),
                        text = getGreetings() + " " + uiState.userName,
                        fontSize = 22.sp
                    )
                }
            }
            items(uiState.data?.problems ?: emptyList()) { medicine ->
                Card(
                    onClick = { onMedicineClick(medicine) },
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                )
                {
                    Column {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = medicine.diabetes?.first()?.name ?: "",
                            fontSize = 22.sp,
                        )
                        val list =
                            medicine.diabetes?.first()
                                ?.medications?.first()
                                ?.medicationsClasses ?: emptyList()
                        list.forEach { medication ->
                            medication.medicine1?.forEach { medicine ->
                                medicine.drug1?.forEach { drug ->
                                    Text(
                                        modifier = Modifier.padding(10.dp),
                                        text = ("Medicine: " + drug.name),
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        modifier = Modifier.padding(10.dp),
                                        text = ("Dose: " + drug.dose),
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        modifier = Modifier.padding(10.dp),
                                        text = ("Strength: " + drug.strength),
                                        fontSize = 18.sp
                                    )
                                }
                                medicine.drug2?.forEach { drug ->
                                    Text(
                                        modifier = Modifier.padding(10.dp),
                                        text = ("Medicine: " + drug.name),
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        modifier = Modifier.padding(10.dp),
                                        text = ("Dose: " + drug.dose),
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        modifier = Modifier.padding(10.dp),
                                        text = ("Strength: " + drug.strength),
                                        fontSize = 18.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}