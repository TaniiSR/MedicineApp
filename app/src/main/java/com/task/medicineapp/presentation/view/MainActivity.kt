package com.task.medicineapp.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.task.medicineapp.presentation.ui.LoginScreen
import com.task.medicineapp.ui.theme.MedicineAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.getMedicines()
        enableEdgeToEdge()
        setContent {
            navHostController = rememberNavController()
            MedicineAppTheme {
                NavHost(
                    navController = navHostController,
                    startDestination = MainScreensRoute.LoginScreen.route,
                ) {
                    composable(MainScreensRoute.LoginScreen.route) {
                        LoginScreen(
                            onLoginClick = {
                                // Navigate to the next screen
                            }
                        )
                    }
                }
            }
        }
    }
}