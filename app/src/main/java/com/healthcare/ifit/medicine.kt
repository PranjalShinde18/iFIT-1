package com.healthcare.ifit

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.healthcare.ifit.ui.theme.IFITTheme
import java.text.SimpleDateFormat
import java.util.*

class Medicine : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IFITTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Reminder(
                        onHome = {}
                    )
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Reminder(
    onHome: ()-> Unit
) {
    var showReminder by remember { mutableStateOf(false) }
    var medicineName by remember { mutableStateOf("") }
    var medicineUnit by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Everyday") }
    var startDate by remember { mutableStateOf(Date()) }
    var endDate by remember { mutableStateOf(Date()) }
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val selectedDays = remember { mutableStateListOf<String>() }

    if (showReminder) {
        Card(
            backgroundColor = Color.Black,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .animateContentSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Don't forget to take your medicine!",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = medicineName,
                    onValueChange = { medicineName = it },
                    label = { Text("Medicine name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = medicineUnit,
                    onValueChange = { medicineUnit = it },
                    label = { Text("Unit of medicine") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Start date: ${startDate.toDateString()}",
//                        text = "Start date: ${startDate.toDateString()}",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "End date: ${endDate.toDateString()}",
//                        text = "End date: ${endDate.toDateString()}",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Switch(
                    checked = frequency == "Specific Days",
                    onCheckedChange = {
                        if (it) {
                            frequency = "Specific Days"
                        } else {
                            frequency = "Everyday"
                        }
                    },
                    modifier = Modifier.align(Alignment.End)
                )
                if (frequency == "Specific Days") {
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Select the days:",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        daysOfWeek.forEach { day ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 4.dp)
                            ) {
                                Checkbox(
                                    checked = selectedDays.contains(day),
                                    onCheckedChange = {
                                        if (it) {
                                            selectedDays.add(day)
                                        } else {
                                            selectedDays.remove(day)
                                        }
                                    }
                                )
                                Text(
                                    text = day,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onHome,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Dismiss")
                }
            }
        }
    }


    LaunchedEffect(Unit) {
        // Replace this with your own logic to determine when to show the reminder
        val shouldShowReminder = true

        if (shouldShowReminder) {
            showReminder = true
        }
    }
}

private fun Date.toDateString(): String {
    val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    return sdf.format(this)
}