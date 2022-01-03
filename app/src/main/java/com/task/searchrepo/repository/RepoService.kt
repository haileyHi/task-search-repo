package com.task.searchrepo.repository

import com.task.searchrepo.model.SearchInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoService {
    companion object {
        const val BASE_URL: String = "https://api.github.com/search/"
    }

    @GET("repositories")
    suspend fun fetchRepo(@Query("q") keyword: String,
                          @Query("page") page: Int? = 1,
                          @Query("per_page") perPage: Int? = 30): SearchInfo
}