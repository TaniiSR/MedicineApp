package com.task.medicineapp.data.dtos

import com.google.gson.annotations.SerializedName

data class MedicationsClass(
    @SerializedName("className")
    val medicine1: List<Medicine>? = null,
    @SerializedName("className2")
    val medicine2: List<Medicine>? = null,
)
