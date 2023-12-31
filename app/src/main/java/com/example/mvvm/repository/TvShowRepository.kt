package com.example.mvvm.repository

import com.example.mvvm.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val apiService: ApiService){
    suspend fun getTvShows() = apiService.getTvShows()
}