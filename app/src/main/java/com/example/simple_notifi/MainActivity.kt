package com.example.simple_notifi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simple_notifi.api.ApiUtilities
import com.example.simple_notifi.models.Notification
import com.example.simple_notifi.models.NotificationData
import com.example.simple_notifi.ui.theme.Simple_NotifiTheme
import com.google.firebase.messaging.FirebaseMessaging
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Simple_NotifiTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                )
                {
                    Button(onClick = {
                        FirebaseMessaging.getInstance().token.addOnCompleteListener {
                            val token = it.result
                            val tokke = "fCQdAlMpQWuQqafOHI2xQw:APA91bGFhd5bNcO8ADgq6AT5G_NRiQc9IEOWy87qRPpL1-AUC4G7kFxP9f9FLOPnIQ_AXExTNA4i2zMDbquaiw80tVPYYPPkyU6NjwmXw259UXrRQuMKPr_t-eL0sm3nL65LReaXxly3"
                            Log.d("hh" , token.toString())
                            val notification = Notification(tokke , NotificationData("hello" , "hey how are you"))
                            ApiUtilities.notificationApi.sendNotification(notification).enqueue(object :
                                Callback<Notification> {
                                override fun onResponse(
                                    call: Call<Notification>,
                                    response: Response<Notification>
                                ) {
                                    if (response.isSuccessful){

                                    }
                                }
                                override fun onFailure(call: Call<Notification>, t: Throwable) {
                                    TODO("Not yet implemented")
                                }

                            })
                        }
                        val notificationIntent = Intent("com.example.simple_notifi.ACTION_NOTIFICATION_RECEIVED")
                        sendBroadcast(notificationIntent)
                    }) {
                        Text(text = "Send")
                    }
                }
            }
        }
    }
}

