package com.task.medicineapp.presentation.view

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.task.medicineapp.data.dtos.AssociateDrug
import com.task.medicineapp.data.dtos.DataResponse
import com.task.medicineapp.data.dtos.Disease
import com.task.medicineapp.data.dtos.Medication
import com.task.medicineapp.data.dtos.MedicationsClass
import com.task.medicineapp.data.dtos.Medicine
import com.task.medicineapp.data.dtos.Problem
import com.task.medicineapp.data.localSource.entities.UserEntity
import com.task.medicineapp.data.remoteSource.base.NetworkResult
import com.task.medicineapp.domain.usecases.GetMedicinesUseCase
import com.task.medicineapp.domain.usecases.GetUserUseCase
import com.task.medicineapp.domain.usecases.SaveUserUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var underTest: MainViewModel
    private val getMedicinesUseCase: GetMedicinesUseCase = mockk()
    private val getUserUseCase: GetUserUseCase = mockk()
    private val saveUserUseCase: SaveUserUseCase = mockk()
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.Unconfined

    @BeforeAll
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    private fun initTestClass() {
        underTest = MainViewModel(
            getMedicinesUseCase = getMedicinesUseCase,
            getUserUseCase = getUserUseCase,
            saveUserUseCase = saveUserUseCase,
            ioDispatcher = ioDispatcher,
        )
    }

    @Test
    fun `test that uiState has the correct value before calling getMedicine`() = runTest {
        coEvery { getMedicinesUseCase() } returns mockk()
        initTestClass()
        underTest.uiState.test {
            val state = awaitItem()
            assertThat(state.isLoading).isEqualTo(false)
        }
    }

    @Test
    fun `test that uiState has the correct values when getMedicine returns valid data`() =
        runTest {
            val expectedData = DataResponse(
                problems = listOf(
                    Problem(
                        diabetes = listOf(
                            Disease(
                                name = "Diabetes",
                                medications = listOf(
                                    Medication(
                                        medicationsClasses = listOf(
                                            MedicationsClass(
                                                medicine1 = listOf(
                                                    Medicine(
                                                        drug1 = listOf(
                                                            AssociateDrug(
                                                                name = "Drug",
                                                                dose = "Dose",
                                                                strength = "Strength"
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
            coEvery { getMedicinesUseCase() } returns NetworkResult.Success(
                expectedData
            )
            initTestClass()
            underTest.getMedicines()
            advanceUntilIdle()
            underTest.uiState.test {
                val state = awaitItem()
                assertThat(state.isLoading).isFalse()
                assertThat(state.isError).isFalse()
                assertThat(state.data).isEqualTo(expectedData)
            }
        }

    @Test
    fun `test that uiState has the correct values when getMedicines returns error data`() =
        runTest {
            coEvery { getMedicinesUseCase() } returns NetworkResult.Error(
                error = Exception("An error occurred")
            )
            initTestClass()
            underTest.getMedicines()
            advanceUntilIdle()
            underTest.uiState.test {
                val state = awaitItem()
                assertThat(state.isLoading).isFalse()
                assertThat(state.isError).isTrue()
            }
        }

    @Test
    fun `test that uiState has the correct values when getUser returns valid data`() =
        runTest {
            val user = "User"
            coEvery {
                getUserUseCase(
                    user
                )
            } returns UserEntity(userName = user, userPass = "Password")
            initTestClass()
            underTest.getUser(user)
            advanceUntilIdle()
            underTest.uiState.test {
                val state = awaitItem()
                assertThat(state.isLoading).isFalse()
                assertThat(state.isError).isFalse()
                assertThat(state.userName).isEqualTo(user)
            }
        }

    @Test
    fun `test that uiState has the correct values when getUser returns error data`() =
        runTest {
            val user = "User"
            coEvery {
                getUserUseCase(
                    user
                )
            } returns null
            initTestClass()
            underTest.getUser(user)
            advanceUntilIdle()
            underTest.uiState.test {
                val state = awaitItem()
                assertThat(state.isLoading).isFalse()
                assertThat(state.isError).isTrue()
            }
        }

    @Test
    fun `test that uiState has the correct values when saveUser returns error data`() =
        runTest {
            val user = "User"
            val userPass = "Password"
            coEvery {
                saveUserUseCase(
                    user,
                    userPass
                )
            } returns 0
            initTestClass()
            underTest.getUser(user)
            advanceUntilIdle()
            underTest.uiState.test {
                val state = awaitItem()
                assertThat(state.isLoading).isFalse()
                assertThat(state.isError).isTrue()
            }
        }

    @Test
    fun `test that uiState has the correct values when saveUser returns valid data`() =
        runTest {
            val user = "User"
            val userPass = "Password"
            coEvery {
                saveUserUseCase(
                    user,
                    userPass
                )
            } returns 1
            coEvery {
                getUserUseCase(
                    user
                )
            } returns UserEntity(userName = user, userPass = "Password")
            initTestClass()
            underTest.getUser(user)
            advanceUntilIdle()
            underTest.uiState.test {
                val state = awaitItem()
                assertThat(state.isLoading).isFalse()
                assertThat(state.isError).isFalse()
                assertThat(state.userName).isEqualTo(user)
            }
        }
}