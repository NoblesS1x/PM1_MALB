package net.noble.notes_nav_try.Multimedia

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
//import com.example.notas.R
import net.noble.notes_nav_try.Multimedia.Constants.channelId

class notificacionProgramada:BroadcastReceiver() {
    companion object{
        const val NOTIFICACION_ID = 5
    }
    override fun onReceive(context: Context, intent: Intent?) {
        crearNoficacion(context)
    }
    private fun crearNoficacion(context: Context){

        val notificacion = NotificationCompat.Builder(context,channelId)
            .setSmallIcon(androidx.media.R.drawable.notification_bg)
            .setContentTitle("Finalizacion de tarea")
            .setContentText("la fecha de limite de la tarea a finalizado")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(
                        "La fecha limite establecida para la tarea a finalizado"+
                                "Da click apra abrir la App y ver tu tarea"
                    )
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        manager.notify(NOTIFICACION_ID,notificacion)
    }
}