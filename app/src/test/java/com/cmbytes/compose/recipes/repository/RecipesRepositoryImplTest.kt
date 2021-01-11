package com.cmbytes.compose.recipes.repository

import com.cmbytes.compose.domain.error.ErrorState
import com.cmbytes.compose.domain.resulttypes.ResultType
import com.cmbytes.compose.recipes.domain.models.Recipes
import com.cmbytes.compose.recipes.network.RecipesDataSource
import com.cmbytes.compose.recipes.network.models.RecipesNet
import com.cmbytes.compose.recipes.repository.mappers.RecipesMapper
import com.cmbytes.compose.testing.general.BaseTest
import io.mockk.coEvery
import io.mockk.coVerifySequence
import io.mockk.every
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RecipesRepositoryImplTest : BaseTest() {

    private val mockRecipesDataSource = mockk<RecipesDataSource>()
    private val mockRecipesMapper = mockk<RecipesMapper>()
    private val mockRecipesNet = mockk<RecipesNet>()
    private val mockRecipes = mockk<Recipes>()

    private val sut = RecipesRepositoryImpl(mockRecipesDataSource, mockRecipesMapper)

    @Test
    fun `getRecipes() - calls data source and returns success`() {
        val mockResultTypeNet = ResultType.Success(mockRecipesNet)
        val mockResultType = ResultType.Success(mockRecipes)
        every { mockRecipesMapper.to(mockResultTypeNet)  } returns mockResultType
        coEvery { mockRecipesDataSource.getRecipes() } returns mockResultTypeNet

        runBlocking {
            val result = sut.getRecipes()

            coVerifySequence {
                mockRecipesDataSource.getRecipes()
                mockRecipesMapper.to(mockResultTypeNet)
            }
            assertThat(result).isEqualTo(mockResultType)
        }
    }

    @Test
    fun `getRecipes() - calls data source and returns error`() {
        val mockResultTypeNet = ResultType.Error(ErrorState.ConnectivityError)
        val mockResultType = ResultType.Error(ErrorState.ConnectivityError)
        every { mockRecipesMapper.to(mockResultTypeNet)  } returns mockResultType
        coEvery { mockRecipesDataSource.getRecipes() } returns mockResultTypeNet

        runBlocking {
            val result = sut.getRecipes()

            coVerifySequence {
                mockRecipesDataSource.getRecipes()
                mockRecipesMapper.to(mockResultTypeNet)
            }
            assertThat(result).isEqualTo(mockResultType)
        }
    }
}