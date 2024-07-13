package com.task.medicineapp.data

import com.task.medicineapp.data.dtos.DataResponse
import com.task.medicineapp.data.localSource.entities.UserEntity
import com.task.medicineapp.data.remoteSource.base.NetworkResult

interface IMedicineRepository {
    suspend fun fetchMedicines(): NetworkResult<DataResponse>
    suspend fun saveUser(userName: String, password: String): Long
    suspend fun getUser(userName: String): UserEntity?
}