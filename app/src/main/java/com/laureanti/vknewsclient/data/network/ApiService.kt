package com.laureanti.vknewsclient.data.network

import com.laureanti.vknewsclient.data.model.NewsFeedResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("newsfeed.getRecommended?v=5.131")
    suspend fun loadRecommendations (
        @Query("access_token") token: String
    ): NewsFeedResponseDto
}