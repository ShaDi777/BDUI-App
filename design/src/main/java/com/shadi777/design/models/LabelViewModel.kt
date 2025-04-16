package com.shadi777.design.models

import com.shadi777.design.types.LayoutModifiers
import com.shadi777.design.types.Typography

data class LabelViewModel(
    val text: String,
    val typography: Typography = Typography.BODY2,
    val style: LabelStyle = LabelStyle.PRIMARY,
    val layout: LayoutModifiers = LayoutModifiers(),
) {
    enum class LabelStyle {
        PRIMARY, SECONDARY, POSITIVE, WARNING, DANGER
    }
}
