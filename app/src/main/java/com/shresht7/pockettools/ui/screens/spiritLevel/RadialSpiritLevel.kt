package com.shresht7.pockettools.ui.screens.spiritLevel

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.shresht7.pockettools.data.Orientation

@Composable
fun SpiritLevel(orientation: Orientation) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val bubbleRadius = 40.dp.toPx()
        val maxOffset = size.minDimension / 3f

        fun map(value: Float): Float {
            return (value / 45f).coerceIn(-1f, 1f) * maxOffset
        }

        val bubbleX = size.center.x + map(orientation.roll)
        val bubbleY = size.center.y + map(orientation.pitch)

        // Background Circle
        drawCircle(
            color = Color(0xFF333333),
            radius = maxOffset * 1.2f,
            center = size.center,
            style = Stroke(width = 8.dp.toPx())
        )

        // Center Crosshair
        drawLine(
            color = Color.Gray,
            start = Offset(size.center.x - maxOffset, size.center.y),
            end = Offset(size.center.x + maxOffset, size.center.y),
            strokeWidth = 4.dp.toPx()
        )
        drawLine(
            color = Color.Gray,
            start = Offset(size.center.x, size.center.y - maxOffset),
            end = Offset(size.center.x, size.center.y + maxOffset),
            strokeWidth = 4.dp.toPx()
        )

        // Bubble
        drawCircle(
            color = primaryColor,
            radius = bubbleRadius,
            center = Offset(bubbleX, bubbleY)
        )
    }
}