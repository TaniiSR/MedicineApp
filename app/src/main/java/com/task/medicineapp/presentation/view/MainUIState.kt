package com.task.medicineapp.presentation.view

import com.task.medicineapp.data.dtos.DataResponse


/**
 * UI state for [MainActivity]
 * @param isLoading Loading state
 */
data class MainUIState(
    val isLoading: Boolean = false,
    val data: DataResponse? = null,
    val isError: Boolean = false,
    val errorMessage: String = ""
)

