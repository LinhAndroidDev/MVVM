package com.example.mvvm.api

import com.example.mvvm.helper.Constants
import com.example.mvvm.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.ENT_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>
}