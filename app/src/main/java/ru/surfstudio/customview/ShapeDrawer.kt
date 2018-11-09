package ru.surfstudio.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.MotionEvent.ACTION_DOWN
import android.widget.Toast
import ru.surfstudio.customview.shape.*
import kotlin.collections.ArrayList

class ShapeDrawer @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : View(context, attrs) {

    private val colorArray: MutableList<Int> = ArrayList()
    private var shapeColor: Int = Color.GREEN
    private val shapes: MutableList<Shape> = ArrayList()
    private val shapeFactory: RandomShapeFactory
    private val textPaint: Paint

    init {
        shapeFactory = RandomShapeFactory(context, colorArray)
        textPaint = Paint()
        textPaint.color = Color.BLACK
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = 20f

        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.ShapeDrawer,
                0, 0
        ).apply {
            try {
                shapeColor = getColor(R.styleable.ShapeDrawer_color, shapeColor)
            } finally {
                recycle()
            }
        }
        colorArray.add(shapeColor)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        drawCount(canvas)
        for (shape in shapes) {
            shape.draw(canvas)
        }
        canvas.restore()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == ACTION_DOWN) {
            if (shapes.size == 10) {
                shapes.clear()
                Toast.makeText(context, "Game over!", Toast.LENGTH_SHORT).show()
            } else {
                shapes.add(shapeFactory.createShape(event.x, event.y))
            }
            invalidate()
        }
        return super.onTouchEvent(event)
    }

    fun setColorArray(hexColors: Array<String>) {
        this.colorArray.clear()
        this.colorArray.addAll(hexColors.map { Color.parseColor(it) })
    }

    fun setColorArray(colorArray: Array<Int>) {
        this.colorArray.clear()
        this.colorArray.addAll(colorArray)
    }

    private fun drawCount(canvas: Canvas) {
        canvas.drawText("Count of shapes: ${shapes.size}", 0f, 15f, textPaint)
    }
}