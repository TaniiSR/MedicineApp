package com.task.medicineapp.di

import android.content.Context
import androidx.room.Room
import com.task.medicineapp.data.localSource.base.MedicineDB
import com.task.medicineapp.data.localSource.dao.UserDao
import com.task.medicineapp.data.remoteSource.dataService.DataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun providesReposService(): DataService = DataService.createService()

    @Provides
    fun providesIoDispatcher() = Dispatchers.IO

    @Provides
    @Singleton
    fun provideAppDB(@ApplicationContext appContext: Context): MedicineDB {
        return Room.databaseBuilder(
            appContext,
            MedicineDB::class.java,
            "MedicineApp"
        ).build()
    }

    @Provides
    fun provideNoteDao(appDatabase: MedicineDB): UserDao {
        return appDatabase.userDao()
    }
}