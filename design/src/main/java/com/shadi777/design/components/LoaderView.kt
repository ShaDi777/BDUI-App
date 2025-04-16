package com.shadi777.design.components

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.shadi777.design.models.LoaderViewModel
import com.shadi777.design.types.Color
import com.shadi777.design.utils.applyLayout
import kotlin.math.min

class LoaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val fullPath = Path()
    private val segmentPath = Path()
    private var pathMeasure: PathMeasure? = null
    private var pathLength = 0f
    private var isPathReady = false

    private var strokeColor: Int = Color.BACKGROUND_BRAND_PRIMARY.value
    private var strokeWidth: Float = 8.dp
    private var duration: Long = 1500

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }

    private var animator: ValueAnimator? = null

    fun configure(viewModel: LoaderViewModel) {
        paint.color = strokeColor
        paint.strokeWidth = strokeWidth

        applyLayout(viewModel.layout)

        animator?.cancel()
        animator = createAnimator()
        if (isPathReady) {
            animator?.start()
        }
    }

    private fun createAnimator(): ValueAnimator {
        return ValueAnimator.ofFloat(0f, 1f).apply {
            duration = this@LoaderView.duration
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                if (isPathReady) {
                    updateSegment(it.animatedValue as Float)
                    invalidate()
                }
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        buildInfinityPath(w, h)
        isPathReady = true
        animator?.start()
    }

    private fun buildInfinityPath(viewWidth: Int, viewHeight: Int) {
        val width = min(viewWidth, viewHeight) * 0.9f
        val halfW = width / 2
        val halfH = width / 4
        val centerX = viewWidth / 2f
        val centerY = viewHeight / 2f

        fullPath.reset()
        fullPath.moveTo(centerX, centerY)
        fullPath.cubicTo(
            centerX + halfW / 2, centerY - halfH,
            centerX + halfW, centerY + halfH,
            centerX, centerY
        )
        fullPath.cubicTo(
            centerX - halfW, centerY - halfH,
            centerX - halfW / 2, centerY + halfH,
            centerX, centerY
        )

        pathMeasure = PathMeasure(fullPath, true)
        pathLength = pathMeasure!!.length
    }

    private fun updateSegment(progress: Float) {
        val measure = pathMeasure ?: return
        val segmentLen = pathLength / 2
        val start = (progress * pathLength) % pathLength
        val end = (start + segmentLen) % pathLength

        segmentPath.reset()
        if (start < end) {
            measure.getSegment(start, end, segmentPath, true)
        } else {
            measure.getSegment(start, pathLength, segmentPath, true)
            measure.getSegment(0f, end, segmentPath, true)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (isPathReady) {
            canvas.drawPath(segmentPath, paint)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator?.cancel()
    }

    val Int.dp: Float
        get() = this * Resources.getSystem().displayMetrics.density
}
