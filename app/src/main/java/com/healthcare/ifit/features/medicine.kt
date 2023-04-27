package com.healthcare.ifit.features

import android.widget.DatePicker
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthcare.ifit.ShowNotificationScreen
import com.healthcare.ifit.TimeSetter
import com.healthcare.ifit.ui.theme.IFITTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun Reminder(
    onHome: ()-> Unit
) {
    var showReminder by remember { mutableStateOf(true) }
    var medicineName by remember { mutableStateOf("") }
    var medicineUnit by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Everyday") }
    val startDate by remember { mutableStateOf(Date()) }
    val endDate by remember { mutableStateOf(Date()) }
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val selectedDays = remember { mutableStateListOf<String>() }

    if (showReminder) {
        Card(
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .animateContentSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Don't forget to take your medicine!",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    style = MaterialTheme.typography.h5
                )
               // Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = medicineName,
                    onValueChange = { medicineName = it },
                    label = { Text("Medicine name") },
                    modifier = Modifier.fillMaxWidth()
                )
               // Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = medicineUnit,
                    onValueChange = { medicineUnit = it },
                    label = { Text("Unit of medicine") },
                    modifier = Modifier.fillMaxWidth()
                )
                //Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Start date: ${startDate.toDateString()}",
//                        text = "Start date: ${startDate.toDateString()}",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(1f)
                    )
                  //  Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "End date: ${endDate.toDateString()}",
//                        text = "End date: ${endDate.toDateString()}",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(1f)
                    )
                }



               // Spacer(modifier = Modifier.height(8.dp))
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
                            color = Color.Black
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
    //=   Spacer(modifier = Modifier.height(8.dp))
                TimeSetter()
                ShowNotificationScreen(medicineName)
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

@Preview(showBackground = false)
@Composable
fun ReminderPreview() {
    IFITTheme() {
        Reminder(){}
    }

}