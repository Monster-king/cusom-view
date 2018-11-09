package ru.surfstudio.customview.shape

import android.content.Context
import android.graphics.PointF
import android.graphics.RectF
import android.util.TypedValue
import java.lang.IllegalArgumentException
import java.util.*

private const val CIRCLE = 0
private const val RECT = 1
private const val ROUND_RECT = 2
private const val MAX_DP = 50
private const val MIN_DP = 10

class RandomShapeFactory(private val context: Context, private val colors: List<Int>) {
    private val rand = Random()

    fun createShape(x: Float, y: Float): Shape {
        return when (rand.nextInt(3)) {
            CIRCLE -> createCircle(x, y)
            RECT -> createRect(x, y)
            ROUND_RECT -> createRoundRec(x, y)
            else -> throw IllegalArgumentException("Unknown shape id")
        }
    }
    private fun createCircle(x: Float, y: Float): Circle {
        val center = PointF(x, y)
        val color = randomColor()
        val radius = randomSize()
        return Circle(color, center, radius)
    }

    private fun createRect(x: Float, y: Float): Rectangle {
        val rect = randomRect(x, y)
        val color = randomColor()
        return Rectangle(color, rect)
    }

    private fun createRoundRec(x: Float, y: Float): RoundRectangle {
        val color = randomColor()
        val rect = randomRect(x, y)
        return RoundRectangle(color, rect, context.dpToFloat(4f), context.dpToFloat(4f))
    }

    private fun randomColor(): Int {
        return colors[rand.nextInt(colors.size)]
    }

    private fun randomRect(x: Float, y: Float): RectF {
        val width = randomSize()
        val height = randomSize()
        val rect = RectF()
        rect.top = (y - height / 2)
        rect.bottom = (y + height / 2)
        rect.left = (x - width / 2)
        rect.right = (x + width / 2)
        return rect
    }

    private fun randomSize(): Float {
        return context.dpToFloat(MIN_DP + rand.nextFloat() * (MAX_DP - MIN_DP))
    }
}