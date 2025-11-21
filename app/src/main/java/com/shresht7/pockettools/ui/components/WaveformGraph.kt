package com.shresht7.pockettools.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * A Composable function that draws a waveform graph for a list of float values.
 *
 * This component normalizes the input values to fit within the canvas dimensions
 * and draws a line graph connecting consecutive data points. It's suitable for
 * visualizing time-series data or any sequential numerical data.
 *
 * @param values A list of [Float] values to be plotted on the graph.
 *               The graph will not be drawn if the list contains fewer than 2 values.
 * @param color The [Color] used to draw the waveform line. Defaults to [Color.Cyan].
 * @param strokeWidth The width of the line used to draw the waveform. Defaults to 3f.
 * @param modifier The modifier for this composable.
 */
@Composable
fun WaveformGraph(
    values: List<Float>,
    color: Color = Color.Cyan,
    strokeWidth: Float = 3f,
    modifier: Modifier = Modifier
) {

    // Determine the minimum and maximum values. Handle cases where list is empty or all values are identical.
    val max = values.maxOrNull() ?: 1f
    val min = values.minOrNull() ?: 0f
    val range = max - min

    Canvas(modifier) {
        // If there aren't at least two values, we cannot make a graph
        if (values.size < 2) return@Canvas

        // Calculate the horizontal step size for each data point
        val step = size.width / (values.size - 1)

        // If the range is zero, all values are the same, draw a flat line
        if (range == 0f) {
            val y = size.height - (values[0] - min) / 1f * size.height // Use 1f to avoid div by zero
            drawLine(
                color = color,
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = strokeWidth
            )
            return@Canvas
        }

        // For each step...
        for (i in 1 until values.size) {
            // Normalize y-values to fit canvas height
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