package com.shresht7.pockettools.ui.screens.spiritLevel

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shresht7.pockettools.data.Orientation

@Composable
fun Readouts(orientation: Orientation, modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(
            text = "Roll (x): ${"%.1f".format(orientation.roll)}°",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Pitch (y): ${"%.1f".format(orientation.pitch)}°",
            style = MaterialTheme.typography.titleMedium
        )
    }
}