package com.healthcare.ifit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview(showBackground = true)
@Composable
fun InputScreen(
    onDoneClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomCenter)
            .padding(bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = null,
            modifier = Modifier
                .size(144.dp)
                .weight(1f, fill = true)
                .wrapContentSize(Alignment.Center)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Height")
            },
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Weight")
            }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Height")
            }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Height")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onDoneClick,
            modifier = Modifier
                .width(144.dp)
                .aspectRatio(3f, false)
        ) {
            Text(text = "Done")
        }
    }

}

@Preview
@Composable
fun InputScreenPreview() {
    InputScreen {}
}