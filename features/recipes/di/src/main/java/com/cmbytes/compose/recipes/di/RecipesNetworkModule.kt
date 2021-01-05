package com.cmbytes.compose.recipes.di

import com.cmbytes.compose.recipes.network.api.RecipesApi
import com.cmbytes.compose.recipes.network.RecipesDataSource
import com.cmbytes.compose.recipes.network.RecipesDataSourceImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object RecipesNetworkModule {

    @Provides
    fun provideRecipesDataSource(
        recipesApi: RecipesApi,
    ): RecipesDataSource = RecipesDataSourceImpl(recipesApi)

    @Provides
    fun provideRecipeApi(retrofit: Retrofit): RecipesApi {
        return retrofit.create(RecipesApi::class.java)
    }
}