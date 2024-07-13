package com.task.medicineapp.data.remoteSource

import com.task.medicineapp.data.dtos.DataResponse
import com.task.medicineapp.data.remoteSource.base.NetworkResult

interface IRemoteDataSource {
    suspend fun fetchMedicines(): NetworkResult<DataResponse>
}