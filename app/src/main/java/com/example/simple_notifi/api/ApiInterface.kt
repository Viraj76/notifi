package com.example.simple_notifi.api

import com.example.simple_notifi.models.Notification
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    @Headers(
        "Content-Type: application/json",
        "Authorization: key=AAAAgTSiYdE:APA91bEpFZHUlPJULIRdkzWXcPMfm6fo9cAWFirv-5a7hvDDFzB7XjM3sTAyhzpreZ0kqeBVeF--aTbngHAeWT-kgsruxSe7f9ls4iNwpyE3Rw7oskhQdnqFtCj_S1cFmshnuwytTvxf"
    )
    @POST("fcm/send")
    fun sendNotification(@Body notification : Notification) : Call<Notification>
}