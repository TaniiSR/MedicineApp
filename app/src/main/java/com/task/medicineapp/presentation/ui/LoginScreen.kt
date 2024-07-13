package com.task.medicineapp.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.task.medicineapp.R

@Composable
fun LoginScreen(
    onLoginClick: (String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Scaffold(modifier = Modifier.fillMaxSize())
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.padding(50.dp))

            TextInputView(
                text = name,
                placeHolder = stringResource(id = R.string.user_name_place_holder)
            ) {
                name = it
            }

            TextInputView(
                isPassword = true,
                text = password,
                placeHolder = stringResource(id = R.string.password_place_holder)
            ) {
                password = it
            }

            BoxButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp),
                text = stringResource(id = R.string.login),
                boxModifier = Modifier.fillMaxWidth()
            ) {
                if (name.isNotBlank() && password.isNotEmpty()) {
                    onLoginClick(name)
                }
            }
        }
    }
}