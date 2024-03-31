package com.noahyip.cryptotest.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.noahyip.cryptotest.model.CurrencyInfo
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CurrencyListFragmentViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<CurrencyInfo>>

    private lateinit var viewModel: CurrencyListFragmentViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = CurrencyListFragmentViewModel()
        viewModel.resultCurrencyList.observeForever(observer)
    }

    @Test
    fun `getResultList returns correct currency list`() {
        val currencyList = listOf(
            CurrencyInfo("BTC", "Bitcoin", ""),
            CurrencyInfo("ETH", "Ethereum", ""),
            CurrencyInfo("LTC", "Litecoin", "")
        )
        viewModel.currencyList = currencyList

        val resultList = viewModel.getResultList()

        assertEquals(currencyList, resultList)
    }

    @Test
    fun `search populates resultCurrencyList with matching currencies`() {
        val expectedResult = CurrencyInfo("BTC", "Bitcoin", "")
        val currencyList = listOf(
            expectedResult,
            CurrencyInfo("ETH", "Ethereum", ""),
            CurrencyInfo("LTC", "Litecoin", "")
        )
        viewModel.currencyList = currencyList

        viewModel.search("Bit")

        val expectedList = listOf(expectedResult)
        assertEquals(expectedList, viewModel.resultCurrencyList.value)
    }
}