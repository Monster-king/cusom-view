package ru.surfstudio.customview.shape

import android.graphics.Canvas
import android.graphics.RectF
import androidx.annotation.ColorInt

class RoundRectangle(
        @ColorInt color: Int,
        private val rect: RectF,
        private val radiusX: Float,
        private val radiusY: Float
) : Shape(color) {
    override fun draw(canvas: Canvas) {
        canvas.drawRoundRect(rect, radiusX, radiusY, paint)
    }
}