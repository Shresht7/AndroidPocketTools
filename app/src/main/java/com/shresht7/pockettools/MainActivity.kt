package com.shresht7.pockettools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.shresht7.pockettools.navigation.AppNavHost
import com.shresht7.pockettools.ui.theme.PocketToolsTheme

/**
 * The main activity for the PocketTools application.
 *
 * This activity serves as the main entry point and hosts the entire UI,
 * which is built using Jetpack Compose. It sets up the theme, enables edge-to-edge
 * display, and initializes the navigation structure with [AppNavHost].
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocketToolsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    AppNavHost(navController)
                }
            }
        }
    }
}
