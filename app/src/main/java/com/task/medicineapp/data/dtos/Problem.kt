package com.task.medicineapp.data.dtos

import com.google.gson.annotations.SerializedName

data class Problem(
    @SerializedName("Diabetes")
    val diabetes: List<Disease>? = null,
)
