package com.shadi777.design.components

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatEditText
import com.shadi777.design.models.TextInputViewModel
import com.shadi777.design.types.Color
import com.shadi777.design.types.Typography
import com.shadi777.design.utils.applyLayout

class TextInputView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatEditText(context, attrs, defStyle) {

    private var regex: Regex? = null
    private var isRestoring = false

    init {
        isSaveEnabled = true
        isFocusableInTouchMode = true
        background = defaultBackground()

        setOnFocusChangeListener { _, hasFocus ->
            background = when {
                !hasFocus -> defaultBackground()
                isValid() -> focusedBackground()
                else -> errorBackground()
            }

            if (hasFocus) {
                requestFocus()
                val imm =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
            }
        }

        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                background = when {
                    isValid() -> focusedBackground()
                    else -> errorBackground()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    fun configure(viewModel: TextInputViewModel) {
        hint = viewModel.hint

        if (!isRestoring) {
            setText(viewModel.initialValue ?: "")
        }

        regex = viewModel.validationRegex?.toRegex()

        applyTypography(viewModel.typography)
        applyLayout(viewModel.layout)

        background = when (viewModel.style) {
            TextInputViewModel.TextInputStyle.ERROR -> errorBackground()
            TextInputViewModel.TextInputStyle.SUCCESS -> successBackground()
            else -> defaultBackground()
        }
    }

    override fun onSaveInstanceState(): Parcelable {
        val superState = super.onSaveInstanceState()

        val bundle = Bundle().apply {
            putParcelable("superState", superState)
            putString("text", text?.toString())
        }
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            isRestoring = true
            super.onRestoreInstanceState(state.getParcelable("superState"))
            state.getString("text")?.let { setText(it) }
            isRestoring = false
        } else {
            super.onRestoreInstanceState(state)
        }
    }

    private fun isValid(): Boolean {
        return regex?.matches(text?.toString().orEmpty()) ?: true
    }

    private fun defaultBackground() = GradientDrawable().apply {
        cornerRadius = 16f
        setColor(Color.parseColor("#F0F0F0"))
    }

    private fun focusedBackground() = GradientDrawable().apply {
        cornerRadius = 16f
        setStroke(2, Color.parseColor("#007AFF"))
        setColor(android.graphics.Color.TRANSPARENT)
    }

    private fun errorBackground() = GradientDrawable().apply {
        cornerRadius = 16f
        setStroke(2, Color.BACKGROUND_DANGER.value)
        setColor(android.graphics.Color.TRANSPARENT)
    }

    private fun successBackground() = GradientDrawable().apply {
        cornerRadius = 16f
        setStroke(2, Color.BACKGROUND_POSITIVE.value)
        setColor(android.graphics.Color.TRANSPARENT)
    }

    private fun applyTypography(typography: Typography) {
        textSize = typography.fontSizeSp.toFloat()
        typeface = when (typography.fontWeight) {
            300 -> Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            400 -> Typeface.DEFAULT
            500 -> Typeface.DEFAULT_BOLD
            else -> Typeface.DEFAULT
        }
    }
}
