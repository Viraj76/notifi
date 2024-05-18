package com.example.simple_notifi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
//        val notificationIntent = Intent(context, OpenActivity::class.java)
//            .apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//        Log.d("startBroac" , "sta")
//        context?.startActivity(notificationIntent)

                Log.d("startBroac" , "sta")

        if (intent?.action == "ACTION_INCOMING_CALL") {
                    Log.d("startBroac" , "sta")

            val activityIntent = Intent(context, OpenActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            context?.startActivity(activityIntent)
        }
    }
}
