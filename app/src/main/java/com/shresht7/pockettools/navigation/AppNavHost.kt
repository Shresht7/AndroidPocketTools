package com.shresht7.pockettools.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CompassCalibration
import androidx.compose.material.icons.filled.FlashlightOn
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material.icons.filled.Straight
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.shresht7.pockettools.ui.screens.counter.CounterScreen
import com.shresht7.pockettools.ui.screens.home.HomeScreen
import com.shresht7.pockettools.ui.screens.magnetometer.MagnetometerScreen
import com.shresht7.pockettools.ui.screens.ruler.RulerScreen
import com.shresht7.pockettools.ui.screens.sensors.SensorsListScreen
import com.shresht7.pockettools.ui.screens.tipCalculator.TipCalculatorScreen
import com.shresht7.pockettools.ui.screens.torch.TorchScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route: String, val title: String) {
    @Serializable
    data object Home: Screen("home", "Home")
    @Serializable
    data object Counter: Screen("counter", "Counter")
    @Serializable
    data object TipCalculator: Screen("tipCalculator", "Tip Calculator")
    @Serializable
    data object Torch: Screen("torch", "Torch")
    @Serializable
    data object Ruler: Screen("ruler", "Ruler")
    @Serializable
    data object SensorsList: Screen("sensorsList", "Sensors List")
    @Serializable
    data object Magnetometer: Screen("magnetometer", "Magnetometer")

    val Screen.icon: ImageVector
        get() = when (this) {
            Home -> Icons.Default.Home
            Counter -> Icons.Default.Add
            Magnetometer -> Icons.Default.CompassCalibration
            Ruler -> Icons.Default.Straight
            SensorsList -> Icons.Default.Sensors
            TipCalculator -> Icons.Default.Payment
            Torch -> Icons.Default.FlashlightOn
        }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    val graph = navController.createGraph(startDestination = Screen.Home) {
        composable<Screen.Home> { HomeScreen(navController) }
        composable<Screen.Counter> { CounterScreen(navController) }
        composable<Screen.TipCalculator> { TipCalculatorScreen(navController) }
        composable<Screen.Torch> { TorchScreen(navController) }
        composable<Screen.Ruler> { RulerScreen(navController) }
        composable<Screen.SensorsList> { SensorsListScreen(navController) }
        composable<Screen.Magnetometer> { MagnetometerScreen(navController) }
    }
    NavHost(
        navController = navController,
        graph = graph,
    )
}