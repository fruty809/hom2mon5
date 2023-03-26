package com.example.hom2mon5

import retrofit2.http.GET
import retrofit2.http.Query

interface LoveCalculatorService {
    @GET("getPercentage")
    suspend fun getLovePercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String
    ): LoveCalculatorResponse
}
