package com.cmbytes.compose.network

import com.cmbytes.compose.domain.resulttypes.ResultType
import com.cmbytes.compose.network.api.RecipesApi
import com.cmbytes.compose.network.models.RecipesNet
import com.cmbytes.compose.utils.BaseTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import retrofit2.Response

class RecipesDataSourceImplTest : BaseTest() {

    private val errorMessage = "Error"
    private val errorCode = 1

    private val mockRecipesApi = mockk<RecipesApi>()
    private val mockRecipesNetResponse = mockk<Response<RecipesNet>>()
    private val mockRecipesNet = mockk<RecipesNet>()

    private val sut = RecipesDataSourceImpl(mockRecipesApi)

    @Test
    fun `getRecipes() returns successful response`() {
        val expectedResult = ResultType.Success(mockRecipesNet)
        every { mockRecipesNetResponse.isSuccessful } returns true
        every { mockRecipesNetResponse.body() } returns mockRecipesNet
        coEvery { mockRecipesApi.getRecipes() } returns mockRecipesNetResponse

        val actualResult = runBlocking { sut.getRecipes() }

        coVerify(exactly = 1) {
            mockRecipesApi.getRecipes()
        }
        assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `getRecipes() returns error`() {
        every { mockRecipesNetResponse.isSuccessful } returns false
        every { mockRecipesNetResponse.code() } returns errorCode
        every { mockRecipesNetResponse.message() } returns errorMessage
        coEvery { mockRecipesApi.getRecipes() } returns mockRecipesNetResponse

        val actualResult = runBlocking { sut.getRecipes() }

        coVerify(exactly = 1) {
            mockRecipesApi.getRecipes()
        }
        assertThat(actualResult).isInstanceOf(ResultType.Error::class.java)
    }
}