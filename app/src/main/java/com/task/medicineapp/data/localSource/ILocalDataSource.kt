package com.task.medicineapp.data.localSource

import com.task.medicineapp.data.localSource.entities.UserEntity

interface ILocalDataSource {
    suspend fun insertUser(user: UserEntity): Long
    suspend fun getUser(userName: String): UserEntity?
}