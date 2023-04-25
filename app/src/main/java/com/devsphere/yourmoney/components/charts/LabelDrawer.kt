package com.devsphere.yourmoney.components.charts

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.sp
import com.devsphere.yourmoney.models.Recurrence
import com.devsphere.yourmoney.ui.theme.LabelSecondary
import com.github.tehras.charts.piechart.utils.toLegacyInt

class LabelDrawer constructor(val recurrence: Recurrence, val lastDay: Int? = -1) :
    com.github.tehras.charts.bar.renderer.label.LabelDrawer {
    private val leftOffset = when (recurrence) {
        Recurrence.Weekly -> 50f
        Recurrence.Monthly -> 13f
        Recurrence.Yearly -> 32f
        else -> 0f
    }

    private val paint = android.graphics.Paint().apply {
        this.textAlign = android.graphics.Paint.Align.CENTER
        this.color = LabelSecondary.toLegacyInt()
        this.textSize = 42f
    }

    override fun drawLabel(
        drawScope: DrawScope,
        canvas: Canvas,
        label: String,
        barArea: Rect,
        xAxisArea: Rect
    ) {
        val monthlyCondition =
            recurrence == Recurrence.Monthly && (
                Integer.parseInt(label) % 5 == 0 ||
                Integer.parseInt(label) == 1 ||
                Integer.parseInt(label) == lastDay
            )
        if (monthlyCondition || recurrence != Recurrence.Monthly)
            canvas.nativeCanvas.drawText(
                label,
                barArea.left + leftOffset,
                barArea.bottom + 65f,
                paint
            )
    }
}