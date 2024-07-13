package com.task.medicineapp.data.dtos

import com.google.gson.annotations.SerializedName

data class Disease(
    @SerializedName("medications")
    val medications: List<Medication>? = null,
    @SerializedName("labs")
    val labs: List<Lab>? = null,
)
