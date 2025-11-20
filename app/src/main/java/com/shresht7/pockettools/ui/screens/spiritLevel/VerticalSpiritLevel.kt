package com.shresht7.pockettools.ui.screens.spiritLevel

import androidx.compose.foundation.Canvas
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shresht7.pockettools.data.Orientation

@Composable
fun VerticalSpiritLevel(orientation: Orientation, modifier: Modifier) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Canvas(modifier) {
        val barHeight = size.height * 0.9f
        val barWidth = 20.dp.toPx()

        val centerX = size.width / 2
        val centerY = size.height / 2

        val maxOffset = barHeight * 0.45f
        val bubbleY = centerY + mapTiltToOffset(-orientation.pitch, maxOffset)
        val bubbleRadius = 14.dp.toPx()

        drawRoundRect(
            color = Color(0xFF444444),
            topLeft = Offset(centerX - barWidth / 2, centerY - barHeight / 2),
            size = Size(barWidth, barHeight),
            cornerRadius = CornerRadius(50f, 50f)
        )

        drawCircle(
            color = primaryColor,
            radius = bubbleRadius,
            center = Offset(centerX, bubbleY)
        )
    }
}