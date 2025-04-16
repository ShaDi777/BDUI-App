package com.shadi777.design.models

import com.shadi777.design.types.LayoutModifiers
import com.shadi777.design.types.Typography

data class ButtonViewModel(
    val text: String,
    val style: ButtonStyle = ButtonStyle.FILLED,
    val colorScheme: ButtonColorScheme = ButtonColorScheme.PRIMARY,
    val typography: Typography = Typography.BODY1,
    val layout: LayoutModifiers = LayoutModifiers(),
    val onClickAction: (() -> Unit)? = null,
) {
    enum class ButtonStyle {
        FILLED, OUTLINED, TEXT
    }

    enum class ButtonColorScheme {
        PRIMARY, SECONDARY, TERTIARY, POSITIVE, WARNING, DANGER
    }
}
