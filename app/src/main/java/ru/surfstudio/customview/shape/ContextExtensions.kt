package ru.surfstudio.customview.shape

import android.content.Context
import android.util.TypedValue

fun Context.dpToFloat(dp: Float): Float {
    val metrics = resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics)
}
