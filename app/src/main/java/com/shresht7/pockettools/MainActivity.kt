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
 * The main activity and entry point for the PocketTools application.
 *
 * This activity hosts the entire UI, built with Jetpack Compose. It sets up the
 * theme, enables edge-to-edge display, and initializes the navigation structure
 * using [AppNavHost].
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocketToolsTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}
