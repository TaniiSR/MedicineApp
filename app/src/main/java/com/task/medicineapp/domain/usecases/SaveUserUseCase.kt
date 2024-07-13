package com.task.medicineapp.domain.usecases

import com.task.medicineapp.data.IMedicineRepository
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(private val repository: IMedicineRepository) {
    suspend operator fun invoke(name:String, password:String) =
        repository.saveUser(name, password)
}
