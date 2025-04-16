package com.shadi777.design.components

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.shadi777.design.models.SliderViewModel
import com.shadi777.design.types.Color
import com.shadi777.design.utils.applyLayout
import kotlin.math.roundToInt

class SliderView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private var min = 0f
    private var max = 100f
    private var value = 50f
    private var step = 1f
    private var style: SliderViewModel.SliderStyle = SliderViewModel.SliderStyle.FILLED

    private val thumbRadius = 20f
    private val trackHeight = 6f
    private val popupHeight = 60f
    private val popupWidth = 100f
    private val popupMargin = 20f

    private val trackPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val progressPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val thumbPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val valuePopupPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BACKGROUND_BRAND_SECONDARY.value
    }

    private val valueTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 36f
        color = Color.TEXT_PRIMARY.value
        textAlign = Paint.Align.CENTER
    }

    private val trackRect = RectF()
    private val progressRect = RectF()

    private var showValuePopup = false
    private var popupAlpha = 0f
    private var popupAnimator: ValueAnimator? = null

    init {
        isClickable = true
        isFocusable = true
    }

    fun configure(model: SliderViewModel) {
        min = model.min
        max = model.max
        value = model.value
        step = model.step
        style = model.style
        applyLayout(model.layout)
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val popupWidth = 120f
        val popupMargin = 20f

        val heightNeeded =
            (thumbRadius * 2 + popupHeight + popupMargin + paddingTop + paddingBottom).toInt()

        val horizontalPadding = (popupWidth / 2 + popupMargin).toInt()
        setPadding(horizontalPadding, paddingTop, horizontalPadding, paddingBottom)

        val resolvedWidth = MeasureSpec.getSize(widthMeasureSpec)
        val resolvedHeight = resolveSize(heightNeeded, heightMeasureSpec)

        setMeasuredDimension(resolvedWidth, resolvedHeight)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        applyStyle()

        val sliderCenterY = height - paddingBottom - thumbRadius
        val availableWidth = width - paddingLeft - paddingRight
        val ratio = (value - min) / (max - min)
        val progressX = paddingLeft + availableWidth * ratio

        trackRect.set(
            paddingLeft.toFloat(),
            sliderCenterY - trackHeight / 2,
            width - paddingRight.toFloat(),
            sliderCenterY + trackHeight / 2
        )
        canvas.drawRoundRect(trackRect, trackHeight / 2, trackHeight / 2, trackPaint)

        progressRect.set(
            paddingLeft.toFloat(),
            sliderCenterY - trackHeight / 2,
            progressX,
            sliderCenterY + trackHeight / 2
        )
        canvas.drawRoundRect(progressRect, trackHeight / 2, trackHeight / 2, progressPaint)

        canvas.drawCircle(progressX, sliderCenterY, thumbRadius, thumbPaint)

        if (showValuePopup || popupAlpha > 0f) {
            valuePopupPaint.alpha = (popupAlpha * 255).toInt()
            valueTextPaint.alpha = (popupAlpha * 255).toInt()

            val popupBottom = sliderCenterY - thumbRadius - popupMargin
            val popupTop = popupBottom - popupHeight
            val popupLeft = progressX - popupWidth / 2
            val popupRight = progressX + popupWidth / 2

            val popupRect = RectF(popupLeft, popupTop, popupRight, popupBottom)
            canvas.drawRoundRect(popupRect, 16f, 16f, valuePopupPaint)

            val valueStr = value.toInt().toString()
            val textY =
                popupTop + popupHeight / 2 - (valueTextPaint.descent() + valueTextPaint.ascent()) / 2
            canvas.drawText(valueStr, progressX, textY, valueTextPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                showValuePopup = true
                animatePopup(true)
                updateValueFromTouch(event.x)
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                updateValueFromTouch(event.x)
                return true
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                showValuePopup = false
                animatePopup(false)
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    private fun updateValueFromTouch(x: Float) {
        val ratio = ((x - paddingLeft) / (width - paddingLeft - paddingRight)).coerceIn(0f, 1f)
        value = (min + (max - min) * ratio).roundToStep(step)
        invalidate()
    }

    private fun animatePopup(show: Boolean) {
        popupAnimator?.cancel()
        val start = popupAlpha
        val end = if (show) 1f else 0f
        popupAnimator = ValueAnimator.ofFloat(start, end).apply {
            duration = 300
            interpolator = DecelerateInterpolator()
            addUpdateListener {
                popupAlpha = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    private fun Float.roundToStep(step: Float): Float {
        return ((this / step).roundToInt()) * step
    }

    private fun applyStyle() {
        when (style) {
            SliderViewModel.SliderStyle.FILLED -> {
                trackPaint.color = Color.BACKGROUND_BRAND_SECONDARY.value
                progressPaint.color = Color.BACKGROUND_BRAND_PRIMARY.value
                thumbPaint.color = Color.TEXT_PRIMARY.value
            }

            SliderViewModel.SliderStyle.OUTLINED -> {
                trackPaint.color = Color.BACKGROUND_BRAND_SECONDARY.value
                progressPaint.color = Color.BACKGROUND_BRAND_PRIMARY.value
                thumbPaint.color = Color.BACKGROUND_BRAND_PRIMARY.value
                trackPaint.style = Paint.Style.STROKE
                trackPaint.strokeWidth = 4f
            }

            SliderViewModel.SliderStyle.GHOST -> {
                trackPaint.color = Color.BACKGROUND_BRAND_SECONDARY.value
                progressPaint.color = Color.TEXT_TERTIARY.value
                thumbPaint.color = Color.TEXT_SECONDARY.value
            }
        }
    }
}
