package net.noble.notes_nav_try.Notificacion

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
//import com.example.notas.R
import net.noble.notes_nav_try.Multimedia.Constants.channelId
import net.noble.notes_nav_try.Notificacion.AlarmNotification.Companion.NOTIFICACION_ID
import net.noble.notes_nav_try.localdatabase.TaskData.TaskData
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

fun TaskAlarm(
    context: Context,
    expiration: LocalTime,
    Task: TaskData

) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    val exact = Calendar.getInstance().apply {
        timeInMillis = System.currentTimeMillis()
        set(Calendar.HOUR_OF_DAY, expiration.hour)
        set(Calendar.MINUTE, expiration.minute)
    }

    val exactIntent = Intent(context, AlarmNotification::class.java)
        .putExtra("title", Task.TiteTask)
        .putExtra("desc", Task.TaskDescription)
        .putExtra("time", expiration.format(DateTimeFormatter.ofPattern("HH:mm")))


    val exactPendingIntent = PendingIntent.getBroadcast(
        context,
        NOTIFICACION_ID,
        exactIntent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )

    alarmManager.setRepeating(
        AlarmManager.RTC_WAKEUP,
        exact.timeInMillis,
        1000 * 20,
        exactPendingIntent
    )
}