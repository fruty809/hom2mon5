package com.example.hom2mon5

import com.google.gson.annotations.SerializedName

data class LoveCalculatorResponse(
    @SerializedName("percentage") val percentage: Int,
    @SerializedName("result") val result: String
)
