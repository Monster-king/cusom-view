package ru.surfstudio.customview.shape

import android.graphics.Canvas
import android.graphics.PointF
import androidx.annotation.ColorInt

class Circle(
        @ColorInt color: Int,
        private val center: PointF,
        private val radius: Float
) : Shape(color) {

    override fun draw(canvas: Canvas) {
        canvas.drawCircle(center.x, center.y, radius, paint)
    }
}