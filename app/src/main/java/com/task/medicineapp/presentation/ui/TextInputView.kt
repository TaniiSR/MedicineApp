package com.task.medicineapp.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.task.medicineapp.utils.CombinedThemePreviewsWithBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputView(
    text: String,
    placeHolder: String,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit
) {
    Row {
        TextField(
            modifier = Modifier
                .weight(1f, fill = true)
                .padding(
                    end = 20.dp,
                    start = 20.dp
                ),
            value = text,
            onValueChange = {
                onValueChange(it)
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                keyboardType = KeyboardType.Text,
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
                containerColor = MaterialTheme.colorScheme.surface,
                unfocusedTextColor = MaterialTheme.colorScheme.primary
            ),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Start),
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = placeHolder,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Center
                )
            },
            visualTransformation = if (isPassword) PasswordVisualTransformation()  else VisualTransformation.None,
            )
    }
}

@CombinedThemePreviewsWithBackground
@Composable
fun ReportReasonPreview() {
    MaterialTheme {
        TextInputView("", "Enter Name" ) {}
    }
}
