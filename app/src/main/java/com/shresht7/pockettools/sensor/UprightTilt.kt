package com.shresht7.pockettools.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import kotlin.math.abs
import kotlin.math.atan2


/**
 * A Composable function that provides the device's upright tilt angle.
 *
 * This function uses the [Sensor.TYPE_GRAVITY] to determine the angle
 * of the device relative to the vertical axis (Z-axis). It's particularly
 * useful for features like a plumb bob, where deviation from the vertical
 * is important.
 *
 * The tilt angle is calculated using `atan2(gX, abs(gY))`. The use of `abs(gY)`
 * means the angle primarily reflects the horizontal deviation from an upright
 * position, making it suitable for representing a plumb bob's swing without
 * distinguishing between forward and backward tilts.
 *
 * The sensor listener is registered when the composable enters the composition
 * and unregistered when it leaves, ensuring efficient resource management.
 *
 * @return The current tilt angle in degrees, where 0 degrees means perfectly upright.
 */
@Composable
fun rememberUprightTilt(): Float {
    val context = LocalContext.current
    val sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    val gravitySensor = remember { sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) }

    var tilt by remember { mutableFloatStateOf(0f) }

    DisposableEffect(Unit) {
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                val gX = event.values[0]
                val gY = event.values[1]
                // val gZ = event.values[2]

                // Calculate tilt based on gravity components.
                // Using abs(gY) ensures the tilt angle reflects horizontal deviation
                // from upright, regardless of whether the device is tilted forwards or backwards.
                tilt = Math.toDegrees(
                    atan2(gX, abs(gY)).toDouble()
                ).toFloat()

            }
            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
        }

        sensorManager.registerListener(listener, gravitySensor, SensorManager.SENSOR_DELAY_UI)
        onDispose { sensorManager.unregisterListener(listener) }
    }

    return tilt
}