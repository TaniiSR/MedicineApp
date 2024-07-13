package com.task.medicineapp.data

import com.task.medicineapp.data.dtos.DataResponse
import com.task.medicineapp.data.remoteSource.base.NetworkResult

interface IMedicineRepository {
    suspend fun fetchMedicines(): NetworkResult<DataResponse>
}