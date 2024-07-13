package com.task.medicineapp.data.dtos

import com.google.gson.annotations.SerializedName

data class DataResponse (
    @SerializedName("problems")
    val problems: List<Problem>? = null,
)
