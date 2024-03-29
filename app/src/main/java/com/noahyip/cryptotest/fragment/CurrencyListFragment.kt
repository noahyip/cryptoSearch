package com.noahyip.cryptotest.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.noahyip.cryptotest.R
import androidx.fragment.app.viewModels
import com.noahyip.cryptotest.adapter.CurrencyListAdapter
import com.noahyip.cryptotest.databinding.FragmentCurrencyListBinding
import com.noahyip.cryptotest.model.CurrencyInfo
import com.noahyip.cryptotest.viewModel.CurrencyListFragmentViewModel

class CurrencyListFragment : Fragment() {
    private lateinit var binding: FragmentCurrencyListBinding
    private val viewModel: CurrencyListFragmentViewModel by viewModels()

    companion object {
        const val CURRENCY_LIST = "list"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.currencyList.value = arguments?.getSerializable(CURRENCY_LIST) as? ArrayList<CurrencyInfo>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyListBinding.inflate(layoutInflater)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.rvCurrencyList.layoutManager = LinearLayoutManager(activity)
        val adapter = CurrencyListAdapter(viewModel.currencyList.value)
        binding.rvCurrencyList.adapter = adapter

        viewModel.currencyList.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}