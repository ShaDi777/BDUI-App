package com.shadi777.design.components

import android.content.Context
import android.graphics.Color.TRANSPARENT
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import com.shadi777.design.models.ButtonViewModel
import com.shadi777.design.types.Color
import com.shadi777.design.utils.applyLayout

class ButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : AppCompatButton(context, attrs, defStyle) {

    fun configure(viewModel: ButtonViewModel) {
        text = viewModel.text
        textSize = viewModel.typography.fontSizeSp.toFloat()
        textAlignment = TEXT_ALIGNMENT_CENTER
        gravity = Gravity.CENTER

        applyLayout(viewModel.layout)

        setTextColor(getTextColor(viewModel.style, viewModel.colorScheme).value)
        background = createBackground(viewModel.style, viewModel.colorScheme)

        setOnClickListener { viewModel.onClickAction?.invoke() }
    }

    private fun createBackground(
        style: ButtonViewModel.ButtonStyle,
        colorScheme: ButtonViewModel.ButtonColorScheme,
    ): GradientDrawable {
        val shape = GradientDrawable()
        shape.cornerRadius = 32f

        val (backColor, _) = extractColorScheme(colorScheme)

        when (style) {
            ButtonViewModel.ButtonStyle.FILLED -> shape.setColor(backColor.value)
            ButtonViewModel.ButtonStyle.OUTLINED -> {
                shape.setColor(Color.BACKGROUND_BRAND_SECONDARY.value)
                shape.setStroke(2, backColor.value)
            }

            ButtonViewModel.ButtonStyle.TEXT -> shape.setColor(TRANSPARENT)
        }

        return shape
    }

    private fun getTextColor(
        style: ButtonViewModel.ButtonStyle,
        colorScheme: ButtonViewModel.ButtonColorScheme,
    ): Color {
        val (backColor, textColor) = extractColorScheme(colorScheme)

        return when (style) {
            ButtonViewModel.ButtonStyle.FILLED -> textColor
            ButtonViewModel.ButtonStyle.OUTLINED -> Color.TEXT_ON_BACKGROUND_SECONDARY
            ButtonViewModel.ButtonStyle.TEXT -> backColor
        }
    }

    private fun extractColorScheme(colorScheme: ButtonViewModel.ButtonColorScheme): Pair<Color, Color> {
        return when (colorScheme) {
            ButtonViewModel.ButtonColorScheme.PRIMARY -> Color.BACKGROUND_BRAND_PRIMARY to Color.TEXT_ON_BACKGROUND_PRIMARY
            ButtonViewModel.ButtonColorScheme.SECONDARY -> Color.BACKGROUND_BRAND_SECONDARY to Color.TEXT_ON_BACKGROUND_SECONDARY
            ButtonViewModel.ButtonColorScheme.TERTIARY -> Color.BACKGROUND_BRAND_TERTIARY to Color.TEXT_ON_BACKGROUND_TERTIARY
            ButtonViewModel.ButtonColorScheme.POSITIVE -> Color.BACKGROUND_POSITIVE to Color.TEXT_ON_BACKGROUND_POSITIVE
            ButtonViewModel.ButtonColorScheme.WARNING -> Color.BACKGROUND_WARNING to Color.TEXT_ON_BACKGROUND_WARNING
            ButtonViewModel.ButtonColorScheme.DANGER -> Color.BACKGROUND_DANGER to Color.TEXT_ON_BACKGROUND_DANGER
        }
    }
}
