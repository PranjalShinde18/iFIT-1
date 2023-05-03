package com.healthcare.ifit

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

fun setAlarm(context: Context) {
    val timeSec = System.currentTimeMillis() + 5000
//    val calendar = Calendar.getInstance()
//    calendar.timeInMillis = System.currentTimeMillis()
//    println(System.currentTimeMillis())
//
//    calendar.set(Calendar.HOUR_OF_DAY, 15)
//    calendar.set(Calendar.MINUTE, 44)
//    calendar.set(Calendar.SECOND, 0)
//
//    val alarmTime = calendar.timeInMillis
//
//    println(alarmTime)

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, Alarm()::class.java)
    val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
    alarmManager.set(AlarmManager.RTC_WAKEUP, timeSec , pendingIntent)

}