package com.example.simple_notifi


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlin.random.Random

class NotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val fullScreenIntent = Intent(this, OpenActivity::class.java)
        val fullScreenPendingIntent = PendingIntent.getActivity(this, 0, fullScreenIntent, 0)
        val channelId = "UserBlinkit"
        val channel = NotificationChannel(channelId , "BlinkitUsers", NotificationManager.IMPORTANCE_HIGH).apply {
            description = "Blinkit users messages"
            enableLights(true)
        }

        val broadcastIntent = Intent(this, NotificationReceiver::class.java).apply {
            action = "ACTION_INCOMING_CALL"
        }
        val broadcastPendingIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
//        val pendingIntent = PendingIntent.getActivity(this,0, Intent(this , UsersMainActivity::class.java),PendingIntent.FLAG_UPDATE_CURRENT)
        val notification = NotificationCompat.Builder(this , channelId)
            .setContentTitle(message.data["title"])
            .setContentText(message.data["body"])
            .setSmallIcon(R.drawable.ic_launcher_background)
//            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
//            .setFullScreenIntent(broadcastPendingIntent, true)
            .build()

        manager.notify(Random.nextInt() , notification)

        // In your notification sending logic
//        val notificationIntent = Intent(this, MainActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//        Log.d("startBroac" , "sta")
//        startActivity(notificationIntent)


    }
}