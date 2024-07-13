package com.task.medicineapp.presentation.view

sealed class MainScreensRoute(val route: String){
    object LoginScreen : MainScreensRoute(LOGIN_SCREEN)
}

const val LOGIN_SCREEN = "login_screen"