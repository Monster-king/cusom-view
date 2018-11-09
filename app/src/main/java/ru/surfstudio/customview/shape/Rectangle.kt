package ru.surfstudio.customview.shape

import android.graphics.Canvas
import android.graphics.RectF
import androidx.annotation.ColorInt

class Rectangle(
        @ColorInt color: Int,
        private val rect: RectF) : Shape(color) {

    override fun draw(canvas: Canvas) {
        canvas.drawRect(rect, paint)
    }
}