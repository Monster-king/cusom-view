package ru.surfstudio.customview.shape

import android.graphics.Canvas
import android.graphics.Paint
import androidx.annotation.ColorInt

abstract class Shape(@ColorInt color: Int) {
    protected val paint = Paint()

    init {
        paint.style = Paint.Style.FILL
        paint.color = color
    }

    abstract fun draw(canvas: Canvas)
}