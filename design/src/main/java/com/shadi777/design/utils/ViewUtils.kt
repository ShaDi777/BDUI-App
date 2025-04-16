package com.shadi777.design.utils

import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.shadi777.design.types.LayoutModifiers

internal fun View.applyLayout(layout: LayoutModifiers) {
    val widthPx = when (val w = layout.width) {
        is LayoutModifiers.Size.Fixed -> dpToPx(w.dp)
        is LayoutModifiers.Size.Wrap -> ViewGroup.LayoutParams.WRAP_CONTENT
        is LayoutModifiers.Size.Match -> ViewGroup.LayoutParams.MATCH_PARENT
    }

    val heightPx = when (val h = layout.height) {
        is LayoutModifiers.Size.Fixed -> dpToPx(h.dp)
        is LayoutModifiers.Size.Wrap -> ViewGroup.LayoutParams.WRAP_CONTENT
        is LayoutModifiers.Size.Match -> ViewGroup.LayoutParams.MATCH_PARENT
    }

    val marginParams = if (layout.weight != null) {
        LinearLayout.LayoutParams(widthPx, heightPx).apply {
            weight = layout.weight
        }
    } else {
        ViewGroup.MarginLayoutParams(widthPx, heightPx)
    }

    marginParams.setMargins(
        layout.margin.left.value,
        layout.margin.top.value,
        layout.margin.right.value,
        layout.margin.bottom.value,
    )

    layoutParams = marginParams

    setPadding(
        layout.padding.left.value,
        layout.padding.top.value,
        layout.padding.right.value,
        layout.padding.bottom.value,
    )
}

internal fun View.dpToPx(dp: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        resources.displayMetrics
    ).toInt()
}
