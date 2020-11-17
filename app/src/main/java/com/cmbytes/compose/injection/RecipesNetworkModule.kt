package com.cmbytes.compose.injection

import com.cmbytes.compose.network.api.RecipesApi
import com.cmbytes.compose.network.RecipesDataSource
import com.cmbytes.compose.network.RecipesDataSourceImpl
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