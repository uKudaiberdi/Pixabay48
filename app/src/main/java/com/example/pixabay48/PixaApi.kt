package com.example.pixabay48

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {

    @GET("/api/")
    fun getImage(
        @Query("q") keyWorld: String,
        @Query("key") key: String = "27811797-f4785bfc630173b1f28672c4a",
    @Query("page") page :Int,
    @Query("per_page") perPage :Int = 5
    ): Call<PixaModel>
}