package com.example.hom2mon5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface LoveCalculatorApi {
    @Headers(
        "x-rapidapi-key: YOUR_API_KEY",
        "x-rapidapi-host: love-calculator.p.rapidapi.com"
    )
    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String
    ): Call<LoveCalculatorResponse>
}