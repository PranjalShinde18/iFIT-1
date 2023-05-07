package com.healthcare.ifit

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat

class Alarm() : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        try {
            showNotification(context )
        } catch (e: Exception) {
            Log.d("Receive Exception", e.printStackTrace().toString())
        }
    }

    fun showNotification(context: Context) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelName = "message_channel"
        val channelId = "message_id"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel((channel))
        }

        val builder = NotificationCompat.Builder(context, channelId)
            .setContentTitle("iFIT")
            .setContentText("This is time for Dolo 650" )
            .setSmallIcon(R.drawable.ifit)
            .setAutoCancel(true)

        manager.notify(1, builder.build())
    }
}