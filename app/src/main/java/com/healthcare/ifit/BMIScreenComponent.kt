package com.healthcare.ifit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun UnitItem(
    text: String,
    textColor: Color = Color.Black,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 22.sp,
            color = textColor
        )
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Select Unit"
        )
    }
}

@Composable
fun InputUnitValue(
    inputValue: String,
    inputUnit: String,
    inputNoColor: Color,
    onUnitValueClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = inputValue,
            fontSize = 40.sp,
            color = inputNoColor,
            modifier = Modifier.clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) { onUnitValueClicked() }
        )
        Text(
            text = inputUnit,
            fontSize = 12.sp
        )
    }
}

@Composable
fun NumberKeyboard(
    modifier: Modifier = Modifier,
    onNumberClick: (String) -> Unit
) {
    Column(modifier = modifier) {
        val numberButtonList = listOf(
            "7", "8", "9", "4", "5", "6",
            "1", "2", "3", "", "0", "."
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            items(numberButtonList) { item ->
                NumberButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    number = item,
                    onClick = onNumberClick
                )
            }
        }
    }
}

@Composable
fun NumberButton(
    modifier: Modifier = Modifier,
    number: String,
    onClick: (String) -> Unit
) {
    if (number != "") {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .padding(10.dp)
                .clip(CircleShape)
                .background(Color(0xFF2f3d2c),)
                .clickable { onClick(number) }
        ) {
            Text(text = number, fontSize = 40.sp)
        }
    }
}

@Composable
fun ColumnScope.SymbolButton(
    symbol: String,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2f3d2c),)
            .clickable { onClick() }
            .padding(15.dp)
            .weight(1f)
            .aspectRatio(1f)
    ) {
        Text(text = symbol, fontSize = 26.sp)
    }
}

@Composable
fun ColumnScope.SymbolButtonWithIcon(
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF2f3d2c),)
            .clickable { onClick() }
            .padding(15.dp)
            .weight(1f)
            .aspectRatio(1f)
            .background(Color(0xFF2f3d2c),)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Backspace Icon",
            tint = Color.Red
        )
    }
}

@Composable
fun BMIResultCard(
    bmi: Double,
    bmiStage: String = "Normal",
    bmiStageColor: Color = Color.Green
) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(15.dp)
            )
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "$bmi", fontSize = 70.sp, color = Color.Red)
            Spacer(modifier = Modifier.width(15.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "BMI", fontSize = 40.sp, color = Color.Gray)
                Text(text = bmiStage, fontSize = 18.sp, color = bmiStageColor)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .background(Color.Gray)
                .shadow(elevation = 5.dp),
            thickness = 5.dp
        )
        Text(
            modifier = Modifier.padding(vertical = 25.dp),
            text = "Information",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Underweight", color = Color.Blue)
            Text(text = "Normal", color = Color.Green)
            Text(text = "Overweight", color = Color.Red)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Black),
                thickness = 5.dp
            )
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Green),
                thickness = 5.dp
            )
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Red),
                thickness = 5.dp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "16.0", fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "18.5", fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "25.0", fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "40.0", fontSize = 18.sp, color = Color.DarkGray)
        }
    }
}

@Composable
fun ShareButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Red,
            contentColor =Color(0xFF2f3d2c),
        )
    ) {
        Text(text = "Share", modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun BottomSheetContent(
    sheetTitle: String,
    sheetItemsList: List<String>,
    onItemClicked: (String) -> Unit,
    onCancelClicked: () -> Unit
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        text = sheetTitle,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    sheetItemsList.forEach { item ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClicked(item) }
        ) {
            Text(
                text = item,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
    Button(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .background(Color.Gray),
        onClick = onCancelClicked,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "Cancel"
        )
    }
}