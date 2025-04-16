package com.shadi777.bdui.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
sealed class BduiAction {
    @Serializable
    data object None : BduiAction()

    @Serializable
    @SerialName("navigate")
    data class Navigate(val route: String) : BduiAction()

    @Serializable
    @SerialName("toast")
    data class ShowToast(val message: String) : BduiAction()

    @Serializable
    @SerialName("reload")
    data class ReloadScreen(val payload: String) : BduiAction()

    @Serializable
    @SerialName("custom")
    data class Custom(val type: String, val payload: JsonElement?) : BduiAction()
}
