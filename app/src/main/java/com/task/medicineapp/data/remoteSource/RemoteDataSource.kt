package com.task.medicineapp.data.remoteSource

import com.task.medicineapp.data.dtos.DataResponse
import com.task.medicineapp.data.remoteSource.base.BaseRepo
import com.task.medicineapp.data.remoteSource.base.NetworkResult
import com.task.medicineapp.data.remoteSource.dataService.DataService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: DataService) : BaseRepo(),
    IRemoteDataSource {
    override suspend fun fetchMedicines(): NetworkResult<DataResponse> {
        return safeApiCall {
            service.fetchMedicines()
        }
    }
}