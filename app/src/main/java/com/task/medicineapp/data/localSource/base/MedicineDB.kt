package com.task.medicineapp.data.localSource.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.task.medicineapp.data.localSource.dao.UserDao
import com.task.medicineapp.data.localSource.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class MedicineDB : RoomDatabase() {
    abstract fun userDao(): UserDao
}