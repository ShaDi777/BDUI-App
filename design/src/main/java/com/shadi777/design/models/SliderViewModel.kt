package com.shadi777.design.models

import com.shadi777.design.types.LayoutModifiers
import kotlinx.serialization.Serializable

class SliderViewModel(
    val min: Float = 0f,
    val max: Float = 100f,
    val value: Float = 50f,
    val step: Float = 1f,
    val style: SliderStyle = SliderStyle.FILLED,
    val layout: LayoutModifiers = LayoutModifiers()
) {
    @Serializable
    enum class SliderStyle {
        FILLED,
        OUTLINED,
        GHOST
    }
}
