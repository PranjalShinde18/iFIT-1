package com.healthcare.ifit

import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat

@Composable
fun ShowNotificationScreen(
    medicine: String
) {
    val context = LocalContext.current
    val notificationLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) {

    }

    LaunchedEffect(key1 = true) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            notificationLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            createNotification(context, medicine)
        }) {
            Text(text = "Show Notification")
        }
    }

}

private fun createNotification(
    context: Context,
    medicine: String
) {
    val notificationManager = BaseApplication.notificationManager

    val notification = NotificationCompat.Builder(context, "channel_id")
        .setContentTitle("iFIT")
        .setContentText("This is time for $medicine" )
        .setSmallIcon(R.drawable.ifit)
        .setAutoCancel(true)
        .addAction(0, "Start", createPendingIntent(context))
        .setContentIntent(createPendingIntent(context))
        .build()

    notificationManager.notify(100, notification)
}

private fun createPendingIntent(
    context: Context
): PendingIntent {

    val flag = PendingIntent.FLAG_IMMUTABLE

    val intent = Intent(context, MainActivity::class.java).apply {
        putExtra("data", "Hey this is notification")
    }

    return PendingIntent.getActivity(context, 100, intent, flag)

}