package com.shadi777.design.components

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.shadi777.design.models.ButtonViewModel
import com.shadi777.design.models.StackViewModel
import com.shadi777.design.utils.applyLayout

class StackView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    fun configure(viewModel: StackViewModel) {
        orientation = when(viewModel.orientation) {
            StackViewModel.Orientation.VERTICAL -> VERTICAL
            StackViewModel.Orientation.HORIZONTAL -> HORIZONTAL
        }

        setBackgroundColor(viewModel.backgroundColor)

        applyLayout(viewModel.layout)
    }
}
