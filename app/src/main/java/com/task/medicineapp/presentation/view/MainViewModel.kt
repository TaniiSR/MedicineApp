package com.task.medicineapp.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.medicineapp.data.remoteSource.base.NetworkResult
import com.task.medicineapp.domain.usecases.GetMedicinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMedicinesUseCase: GetMedicinesUseCase,
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainUIState> =
        MutableStateFlow(MainUIState())
    val uiState = _uiState.asStateFlow()

    /**
     * Get Medicines from the repository
     */
    fun getMedicines() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(isLoading = true)
            }
            runCatching {
                val data = getMedicinesUseCase()
                if (data is NetworkResult.Success) {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            data = data.data
                        )
                    }
                } else {
                    val error = (data as NetworkResult.Error).error
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            isError = true,
                            errorMessage = error.message ?: "An error occurred"
                        )
                    }
                }
            }.onFailure { throwable ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = throwable.message ?: "An error occurred"
                    )
                }
            }
        }
    }
}
