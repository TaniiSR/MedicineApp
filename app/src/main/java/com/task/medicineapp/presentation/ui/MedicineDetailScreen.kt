package com.task.medicineapp.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.task.medicineapp.R
import com.task.medicineapp.data.dtos.Problem

@Composable
fun MedicineDetailScreen(
    detail: Problem,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth()
            ) {
                IconButton(
                    { onBackClick() }, modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back",
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.CenterVertically),
                    text = stringResource(id = R.string.medicine_detail),
                    fontSize = 22.sp
                )
            }
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = detail.diabetes?.first()?.name ?: "",
                fontSize = 22.sp,
            )
            val list =
                detail.diabetes?.first()
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