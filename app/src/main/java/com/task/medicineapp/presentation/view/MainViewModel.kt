package com.task.medicineapp.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.medicineapp.data.dtos.Problem
import com.task.medicineapp.data.remoteSource.base.NetworkResult
import com.task.medicineapp.domain.usecases.GetMedicinesUseCase
import com.task.medicineapp.domain.usecases.GetUserUseCase
import com.task.medicineapp.domain.usecases.SaveUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMedicinesUseCase: GetMedicinesUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainUIState> =
        MutableStateFlow(MainUIState())
    val uiState = _uiState.asStateFlow()
    var medicineDetail : Problem? = null

    /**
     * Get Medicines from the repository
     */
    fun getMedicines() {
        viewModelScope.launch(ioDispatcher) {
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

    /**
     * Get User from the repository
     */
    fun getUser(userName: String) {
        viewModelScope.launch(ioDispatcher) {
            runCatching {
                val data = getUserUseCase(userName)
                data?.let { user ->
                    _uiState.update {
                        it.copy(
                            userName = user.userName,
                        )
                    }
                } ?: run {
                    _uiState.update {
                        it.copy(
                            errorMessage = "User not found",
                            isError = true
                        )
                    }
                }
            }.onFailure {
                _uiState.update {
                    it.copy(
                        errorMessage = "User not found",
                        isError = true,
                    )
                }
            }
        }
    }

    /**
     * save User from the repository
     */
    fun saveUser(userName: String, password: String) {
        viewModelScope.launch(ioDispatcher) {
            runCatching {
                val data = saveUserUseCase(userName, password)
                if (data > 0) {
                    getUser(userName)
                } else {
                    _uiState.update {
                        it.copy(
                            errorMessage = "User not saved",
                            isError = true
                        )
                    }
                }
            }.onFailure {
                _uiState.update {
                    it.copy(
                        errorMessage = "User not saved",
                        isError = true
                    )
                }
            }
        }
    }
}
