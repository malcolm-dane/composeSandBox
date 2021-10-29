package com.mdane.composeSandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mdane.composeSandbox.ui.navigation.EnterAnimation
import com.mdane.composeSandbox.ui.navigation.NavigationScreen
import com.mdane.composeSandbox.screen1.Screen1
import com.mdane.composeSandbox.screen1.Screen1ViewModel
import com.mdane.composeSandbox.screen2.Screen2
import com.mdane.composeSandbox.screen2.Screen2ViewModel
import com.mdane.composeSandbox.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {

    private val screen1ViewModel: Screen1ViewModel by viewModels()
    private val screen2ViewModel: Screen2ViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = NavigationScreen.SCREEN_1.name) {
                    composable(NavigationScreen.SCREEN_1.name) {
                        EnterAnimation {
                            Screen1(navController, screen1ViewModel)
                        }
                    }

                    composable(NavigationScreen.SCREEN_2.name) {
                        EnterAnimation {
                            Screen2(navController, screen2ViewModel)
                        }
                    }
                }
            }
        }
    }
}

