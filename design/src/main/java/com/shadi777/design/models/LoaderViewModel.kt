package com.shadi777.design.models

import com.shadi777.design.types.LayoutModifiers

data class LoaderViewModel(
    val layout: LayoutModifiers = LayoutModifiers(),
    val strokeWidth: Int = 8,
)
