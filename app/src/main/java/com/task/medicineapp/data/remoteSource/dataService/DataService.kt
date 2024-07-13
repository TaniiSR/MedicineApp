package com.task.medicineapp.data.remoteSource.dataService

import com.task.medicineapp.BuildConfig
import com.task.medicineapp.data.dtos.DataResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DataService {
    @GET("54ad0a57-ba47-4efa-b5fb-681cb7437124")
    suspend fun fetchMedicines(): Response<DataResponse>
    companion object {
        private const val BASE_URL = "https://run.mocky.io/v3/"
        fun createService(): DataService {
            val loggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                loggingInterceptor.apply { level = HttpLoggingInterceptor.Level.BODY }
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DataService::class.java)
        }
    }
}
