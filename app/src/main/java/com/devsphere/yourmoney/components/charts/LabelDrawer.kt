package com.devsphere.yourmoney.components.charts

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.sp
import com.devsphere.yourmoney.ui.theme.LabelSecondary
import com.github.tehras.charts.piechart.utils.toLegacyInt

class LabelDrawer : com.github.tehras.charts.bar.renderer.label.LabelDrawer {

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
        canvas.nativeCanvas.drawText(
            label,
            barArea.left + 50f,
            barArea.bottom + 65f,
            paint
        )
    }
}