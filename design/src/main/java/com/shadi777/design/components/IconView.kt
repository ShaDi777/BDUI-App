package com.shadi777.design.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import com.shadi777.design.models.IconViewModel
import com.shadi777.design.utils.applyLayout
import com.shadi777.design.utils.dpToPx

class IconView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : AppCompatImageView(context, attrs, defStyle) {

    @SuppressLint("DiscouragedApi")
    fun configure(model: IconViewModel) {
        val resId = context.resources.getIdentifier(model.name, "drawable", context.packageName)
        if (resId != 0) {
            setImageResource(resId)
        } else {
            setImageDrawable(null)
        }

        applyLayout(model.layout)

        val sizePx = dpToPx(model.size.dp)
        layoutParams = ViewGroup.LayoutParams(sizePx, sizePx)
        scaleType = ScaleType.CENTER_INSIDE
    }
}
