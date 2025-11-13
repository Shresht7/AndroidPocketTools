package com.shresht7.pockettools.ui.screens.sensors

import android.hardware.Sensor
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SensorCard(sensor: Sensor) {
    Card(
        modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = sensor.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Type: ${sensorTypeToString(sensor.type)}")
            Text(text = "Vendor: ${sensor.vendor}")
            Text(text = "Version: ${sensor.version}")
            Text(text = "Range: ${sensor.maximumRange}")
            Text(text = "Resolution: ${sensor.resolution}")
            Text(text = "Power: ${sensor.power}")
        }
    }
}

fun sensorTypeToString(type: Int): String = when (type) {
    Sensor.TYPE_ACCELEROMETER -> "Accelerometer"
    Sensor.TYPE_GYROSCOPE -> "Gyroscope"
    Sensor.TYPE_MAGNETIC_FIELD -> "Magnetometer"
    Sensor.TYPE_LIGHT -> "Light"
    Sensor.TYPE_PRESSURE -> "Barometer"
    Sensor.TYPE_PROXIMITY -> "Proximity"
    Sensor.TYPE_GRAVITY -> "Gravity"
    Sensor.TYPE_LINEAR_ACCELERATION -> "Linear Acceleration"
    Sensor.TYPE_ROTATION_VECTOR -> "Rotation Vector"
    Sensor.TYPE_AMBIENT_TEMPERATURE -> "Temperature"
    Sensor.TYPE_RELATIVE_HUMIDITY -> "Humidity"
    Sensor.TYPE_HEART_RATE -> "Heart Rate"
    else -> "Unknown ($type)"
}