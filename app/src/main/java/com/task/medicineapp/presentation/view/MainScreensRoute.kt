package com.task.medicineapp.presentation.view

sealed class MainScreensRoute(val route: String){
    object LoginScreen : MainScreensRoute(LOGIN_SCREEN)

    object MedicineListScreen : MainScreensRoute(MEDICINE_LIST_SCREEN)
    object MedicineDetailScreen : MainScreensRoute(MEDICINE_DETAIL_SCREEN)
}

const val LOGIN_SCREEN = "login_screen"
const val MEDICINE_LIST_SCREEN = "medicine_list_screen"
const val MEDICINE_DETAIL_SCREEN = "medicine_detail_screen"