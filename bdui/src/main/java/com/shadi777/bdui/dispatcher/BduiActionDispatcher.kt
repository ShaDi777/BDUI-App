package com.shadi777.bdui.dispatcher

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.shadi777.bdui.activity.BduiScreenActivity
import com.shadi777.bdui.models.BduiAction
import com.shadi777.bdui.models.BduiConfig

interface BduiActionDispatcher {
    fun dispatch(action: BduiAction, context: Context)
}

class BduiActionDispatcherImpl : BduiActionDispatcher {
    override fun dispatch(action: BduiAction, context: Context) {
        when (action) {
            is BduiAction.Navigate -> {
                try {
                    if (action.route.startsWith("#")) {
                        val bduiKey = action.route.substring(1)
                        val config = BduiConfig(bduiKey)
                        val intent = BduiScreenActivity.newIntent(context, config)
                        context.startActivity(intent)
                    } else {
                        val clazz = Class.forName(action.route)
                        context.startActivity(Intent(context, clazz))
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "Screen not found", Toast.LENGTH_SHORT).show()
                }
            }

            is BduiAction.ShowToast -> {
                Toast.makeText(context, action.message, Toast.LENGTH_SHORT).show()
            }

            is BduiAction.ReloadScreen -> {
                Log.d("BDUI", "Reload with: ${action.payload}")
            }

            is BduiAction.Custom -> {
                Log.d("BDUI", "Custom action: ${action.type} ${action.payload}")
            }

            BduiAction.None -> Unit
        }
    }
}
