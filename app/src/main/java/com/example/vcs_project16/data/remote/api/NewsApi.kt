package com.example.vcs_project16.data.remote.api

import com.example.vcs_project16.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query
interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country: String = "us",
        @Query("apiKey")
        apiKey: String
    ): NewsResponse
}