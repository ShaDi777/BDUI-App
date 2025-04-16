package com.shadi777.design.models

import com.shadi777.design.types.LayoutModifiers
import com.shadi777.design.types.Typography

data class TextInputViewModel(
    val hint: String,
    val typography: Typography = Typography.BODY2,
    val style: TextInputStyle = TextInputStyle.NORMAL,
    val layout: LayoutModifiers = LayoutModifiers(),
    val initialValue: String? = null,
    val validationRegex: String? = null
) {
    enum class TextInputStyle {
        NORMAL, ERROR, SUCCESS
    }
}
