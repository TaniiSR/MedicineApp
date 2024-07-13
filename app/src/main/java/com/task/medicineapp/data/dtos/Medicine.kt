package com.task.medicineapp.data.dtos

import com.google.gson.annotations.SerializedName

data class Medicine(
    @SerializedName("associatedDrug")
    val drug1: List<AssociateDrug>? = null,
    @SerializedName("associatedDrug#2")
    val drug2: List<AssociateDrug>? = null,
)
