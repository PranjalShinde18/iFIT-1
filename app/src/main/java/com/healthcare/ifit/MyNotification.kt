package com.healthcare.ifit

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import okhttp3.internal.notify

class MyNotification(var context: Context, var medicine :String) {
    val channelId: String = "chinmay"
    val channelName: String = "rahulnotification"
    val notificationManager =
        context.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationBuilder: NotificationCompat.Builder
    fun Notificaion() {
        notificationChannel =
            NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
        notificationManager.createNotificationChannel(notificationChannel)

        notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setContentTitle("iFIT")
            .setContentText("This is time for $medicine" )
            .setSmallIcon(R.drawable.ifit)
            .setAutoCancel(true)
            .addAction(0, "Start", createPendingIntent(context))
            .setContentIntent(createPendingIntent(context))

        notificationManager.notify(100, notificationBuilder.build())

    }
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