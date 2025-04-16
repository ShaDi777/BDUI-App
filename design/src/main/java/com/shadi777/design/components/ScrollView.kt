package com.shadi777.design.components

import android.content.Context
import android.util.AttributeSet
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import com.shadi777.design.models.ScrollViewModel
import com.shadi777.design.utils.applyLayout

class VerticalScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ScrollView(context, attrs) {

    fun configure(viewModel: ScrollViewModel) {
        isFillViewport = true
        setBackgroundColor(viewModel.backgroundColor)
        applyLayout(viewModel.layout)
    }
}

class HorizontalScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : HorizontalScrollView(context, attrs) {

    fun configure(viewModel: ScrollViewModel) {
        isFillViewport = true
        setBackgroundColor(viewModel.backgroundColor)
        applyLayout(viewModel.layout)
    }
}
