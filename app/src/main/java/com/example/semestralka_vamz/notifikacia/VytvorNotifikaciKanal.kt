package com.example.semestralka_vamz.notifikacia

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.semestralka_vamz.R

/**
 * https://android.mpage.sk/cvicenie7.php
 *
 *  Pomocná trieda na správu notifikácií.
 *  Poskytuje funkcie na vytvorenie notifikačného kanála a odosielanie notifikácií.
 *
 */

object NotifikacnyPomocnik {

    // Konštanta pre ID kanála notifikácií
    private const val CHANNEL_ID = "example_channel"

    /**
     * Vytvorí notifikačný kanál, ak beží na API 26 (Android 8.0) alebo vyššom.
     *
     * @param context Kontext aplikácie potrebný na získanie NotificationManager
     */
    fun vytvorNotifikacnyKanal(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Example Channel"
            val descriptionText = "This is an example channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    /**
     * Odošle notifikáciu.
     *
     * @param context Kontext aplikácie potrebný na vytvorenie notifikácie
     * @param title Názov notifikácie
     * @param content Obsah notifikácie
     */
    fun posliNotifikaciu(context: Context, title: String, content: String) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.notifikacia) // Ikona notifikácie
            .setContentTitle(title) // Názov notifikácie
            .setContentText(content) // Obsah notifikácie

        with(NotificationManagerCompat.from(context)) {
            // Skontroluje povolenie na odosielanie notifikácií
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            // Odošle notifikáciu
            notify(System.currentTimeMillis().toInt(), builder.build())
        }
    }
}


