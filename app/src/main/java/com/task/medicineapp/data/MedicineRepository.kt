package com.task.medicineapp.data

import com.task.medicineapp.data.dtos.DataResponse
import com.task.medicineapp.data.localSource.ILocalDataSource
import com.task.medicineapp.data.localSource.entities.UserEntity
import com.task.medicineapp.data.remoteSource.IRemoteDataSource
import com.task.medicineapp.data.remoteSource.base.NetworkResult
import javax.inject.Inject

class MedicineRepository @Inject constructor(
    private val remoteSource: IRemoteDataSource,
    private val localSource: ILocalDataSource
) : IMedicineRepository {
    override suspend fun fetchMedicines(): NetworkResult<DataResponse> {
        return remoteSource.fetchMedicines()
    }

    override suspend fun saveUser(userName: String, password: String): Long {
        val user = UserEntity(userName, password)
        return localSource.insertUser(user)
    }

    override suspend fun getUser(userName: String): UserEntity? {
        return localSource.getUser(userName)
    }
}