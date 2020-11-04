package com.cmbytes.compose.api

import retrofit2.Response
import retrofit2.http.GET

interface RecipesApi {

    @GET("random?apiKey=13c1dc4ff0cc42ca8460d172d53cc31b&number=30")
    suspend fun getRecipes(): Response<RecipesNet>

}