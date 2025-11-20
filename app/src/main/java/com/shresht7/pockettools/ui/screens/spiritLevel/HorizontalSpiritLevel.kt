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
fun HorizontalSpiritLevel(orientation: Orientation, modifier: Modifier) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Canvas(modifier) {
        val barWidth = size.width * 0.9f
        val barHeight = 20.dp.toPx()

        val centerX = size.width / 2
        val centerY = size.height / 2

        val maxOffset = barWidth * 0.45f
        val bubbleX = centerX + mapTiltToOffset(orientation.roll, maxOffset)
        val bubbleRadius = 14.dp.toPx()

        // Bar
        drawRoundRect(
            color = Color(0xF444444),
            topLeft = Offset(centerX - barWidth / 2, centerY - barHeight / 2),
            size = Size(barWidth, barHeight),
            cornerRadius = CornerRadius(50f, 50f)
        )

        // Bubble
        drawCircle(
            color = primaryColor,
            radius = bubbleRadius,
            center = Offset(bubbleX, centerY)
        )
    }
}