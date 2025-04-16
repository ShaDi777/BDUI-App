package com.shadi777.design.models

import com.shadi777.design.types.LayoutModifiers
import kotlinx.serialization.Serializable

data class IconViewModel(
    val name: String,
    val size: Size,
    val layout: LayoutModifiers = LayoutModifiers(),
) {
    @Serializable
    enum class Size(val dp: Int) {
        S(12),
        M(18),
        L(24),
        XL(32),
        XXL(180),
    }
}
