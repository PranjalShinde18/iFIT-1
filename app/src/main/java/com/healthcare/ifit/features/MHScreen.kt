package com.healthcare.ifit.features

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MHScreen {
}

@Composable
fun MyButton(
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    text: String,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(all = 8.dp)
            .size(width = 100.dp, height = 40.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            backgroundColor = Color.Red,
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(text)
    }
}