package com.task.medicineapp.data.dtos

import com.google.gson.annotations.SerializedName

data class Medication (
    @SerializedName("medicationsClasses")
    val medicationsClasses: List<MedicationsClass>? = null,
)