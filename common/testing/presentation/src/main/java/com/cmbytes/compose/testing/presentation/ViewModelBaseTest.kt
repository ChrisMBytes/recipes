package com.cmbytes.compose.testing.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cmbytes.compose.general.coroutines.CoroutineDispatchers
import com.cmbytes.compose.testing.general.BaseTest
import io.mockk.every
import org.junit.Rule
import org.junit.rules.TestRule

abstract class ViewModelBaseTest : BaseTest() {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    val mockCoroutineDispatchers: CoroutineDispatchers = mockk {
        every { main } returns kotlinx.coroutines.Dispatchers.Unconfined
        every { io } returns kotlinx.coroutines.Dispatchers.Unconfined
        every { default } returns kotlinx.coroutines.Dispatchers.Unconfined
    }
}