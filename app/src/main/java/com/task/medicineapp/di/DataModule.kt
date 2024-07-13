package com.task.medicineapp.di

import com.task.medicineapp.data.IMedicineRepository
import com.task.medicineapp.data.MedicineRepository
import com.task.medicineapp.data.localSource.ILocalDataSource
import com.task.medicineapp.data.localSource.LocalDataSource
import com.task.medicineapp.data.remoteSource.IRemoteDataSource
import com.task.medicineapp.data.remoteSource.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideRemoteSource(remoteSource: RemoteDataSource): IRemoteDataSource

    @Binds
    @Singleton
    abstract fun providesLocalSource(localData: LocalDataSource): ILocalDataSource

    @Binds
    @Singleton
    abstract fun provideDataRepository(dataRepository: MedicineRepository): IMedicineRepository
}