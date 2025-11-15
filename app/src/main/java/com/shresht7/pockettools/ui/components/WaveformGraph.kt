package com.shresht7.pockettools.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WaveformGraph(
    values: List<Float>,
    color: Color = Color.Cyan,
    strokeWidth: Float = 3f,
    modifier: Modifier = Modifier
) {

    // Determine the minimum and maximum values
    val max = values.maxOrNull() ?: 1f
    val min = values.minOrNull() ?: 0f
    val range = max - min

    Canvas(modifier) {
        // If there aren't at least two values, we cannot make a graph
        if (values.size < 2) return@Canvas

        // Calculate the step size based on the number of values
        val step = size.width / (values.size - 1)

        // For each step...
        for (i in 1 until values.size) {
            val y1 = size.height - (values[i - 1] - min) / range * size.height
            val y2 = size.height - (values[i] - min) / range * size.height
            // Draw a line between the two points
            drawLine(
                color = color,
                start = Offset((i - 1) * step, y1),
                end = Offset(i * step, y2),
                strokeWidth = strokeWidth
            )
        }
    }
}

@Preview
@Composable
fun WaveformGraphPreview() {
    val values = List(150) {
        (10..100).random().toFloat()
    }
    WaveformGraph(values)
}