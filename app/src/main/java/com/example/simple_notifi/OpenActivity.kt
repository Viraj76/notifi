package com.example.simple_notifi

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.compose.setContent
import com.example.simple_notifi.ui.theme.Simple_NotifiTheme

class OpenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        showWhenLockedAndTurnScreenOn()
        super.onCreate(savedInstanceState)
        setContent {
            Simple_NotifiTheme {

            }
        }

    }

    private fun showWhenLockedAndTurnScreenOn() {
        setShowWhenLocked(true)
        setTurnScreenOn(true)
    }
}