package com.shadi777.bduiapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shadi777.bdui.activity.BduiScreenActivity
import com.shadi777.bdui.models.BduiConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val config = BduiConfig(key = "main-menu")
        val intent = BduiScreenActivity.newIntent(this, config).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    }
}
