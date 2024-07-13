package com.task.medicineapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ButtonView(
    modifier: Modifier = Modifier,
    boxModifier: Modifier,
    text: String,
    textColor: Color,
    onCLick: () -> Unit
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray,
        ),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(50.dp),
        onClick = { onCLick() }
    ) {
        Box(
            modifier = boxModifier
                .clip(RoundedCornerShape(50.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun BoxButton(
    modifier: Modifier = Modifier,
    boxModifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.Cyan,
    backgroundColor: Color =  Color.Black,
    onCLick: () -> Unit
) {
    ButtonView(
        modifier = modifier,
        boxModifier = boxModifier
            .background(color = backgroundColor)
            .padding(horizontal = 30.dp, vertical = 16.dp),
        text = text,
        textColor = textColor,
        onCLick = onCLick
    )
}