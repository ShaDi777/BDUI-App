package com.shadi777.design.models

import androidx.annotation.ColorInt
import com.shadi777.design.types.Color
import com.shadi777.design.types.LayoutModifiers

data class StackViewModel(
    @ColorInt val backgroundColor: Int = Color.BACKGROUND_DEFAULT.value,
    val orientation: Orientation = Orientation.VERTICAL,
    val layout: LayoutModifiers = LayoutModifiers(),
) {
    enum class Orientation {
        VERTICAL, HORIZONTAL
    }
}
