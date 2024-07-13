package com.task.medicineapp.data.localSource

import com.task.medicineapp.data.localSource.dao.UserDao
import com.task.medicineapp.data.localSource.entities.UserEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val userDao: UserDao) : ILocalDataSource {
    override suspend fun insertUser(user: UserEntity): Long = userDao.insertUser(user)
    override suspend fun getUser(userName: String): UserEntity? = userDao.getUser(userName)
}