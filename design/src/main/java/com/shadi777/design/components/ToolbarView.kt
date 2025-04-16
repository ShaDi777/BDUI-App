package com.shadi777.design.components

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.shadi777.design.R
import com.shadi777.design.models.ToolbarViewModel

class ToolbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val backButton: ImageView
    private val centerTitle: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_bdui_toolbar, this, true)
        backButton = findViewById(R.id.backButton)
        centerTitle = findViewById(R.id.centerTitle)

        backButton.setOnClickListener {
            (context as? Activity)?.finish()
        }
    }

    fun configure(viewModel: ToolbarViewModel) {
        backButton.visibility = if (viewModel.backEnabled) VISIBLE else GONE
        centerTitle.text = viewModel.text
    }
}
