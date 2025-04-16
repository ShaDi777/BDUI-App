package com.shadi777.design.components

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import com.shadi777.design.models.LabelViewModel
import com.shadi777.design.types.Color
import com.shadi777.design.types.Typography
import com.shadi777.design.utils.applyLayout

class LabelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {

    fun configure(viewModel: LabelViewModel) {
        text = viewModel.text

        applyLayout(viewModel.layout)

        applyTypography(viewModel.typography)

        val textColor = when (viewModel.style) {
            LabelViewModel.LabelStyle.PRIMARY -> Color.TEXT_PRIMARY.value
            LabelViewModel.LabelStyle.SECONDARY -> Color.TEXT_SECONDARY.value
            LabelViewModel.LabelStyle.POSITIVE -> Color.BACKGROUND_POSITIVE.value
            LabelViewModel.LabelStyle.WARNING -> Color.BACKGROUND_WARNING.value
            LabelViewModel.LabelStyle.DANGER -> Color.BACKGROUND_DANGER.value
        }
        setTextColor(textColor)
    }

    private fun applyTypography(typography: Typography) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, typography.fontSizeSp.toFloat())
        typeface = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Typeface.create(null, typography.fontWeight, false)
        } else {
            val tf: Typeface? = null
            Typeface.create(tf, typography.fontWeight)
        }
    }
}
