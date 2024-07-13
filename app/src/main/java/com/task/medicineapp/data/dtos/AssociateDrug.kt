package com.task.medicineapp.data.dtos

import com.google.gson.annotations.SerializedName

data class AssociateDrug(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("dose")
    val dose: String? = null,
    @SerializedName("strength")
    val strength: String? = null,
)
