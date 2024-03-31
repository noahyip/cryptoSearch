package com.noahyip.cryptotest.fragment

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.viewModels
import com.noahyip.cryptotest.adapter.CurrencyListAdapter
import com.noahyip.cryptotest.databinding.FragmentCurrencyListBinding
import com.noahyip.cryptotest.model.CurrencyInfo
import com.noahyip.cryptotest.viewModel.CurrencyListFragmentViewModel

class CurrencyListFragment : Fragment() {
    private lateinit var binding: FragmentCurrencyListBinding
    private val viewModel: CurrencyListFragmentViewModel by viewModels()

    companion object {
        const val CURRENCY_LIST_TITLE = "title"
        const val CURRENCY_LIST = "list"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (arguments?.getSerializable(CURRENCY_LIST) as? List<CurrencyInfo>)?.let{
            viewModel.currencyList = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyListBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initView()
        return binding.root
    }

    private fun initView() {
        binding.rvCurrencyList.layoutManager = LinearLayoutManager(activity)
        val adapter = CurrencyListAdapter(viewModel.getResultList())
        binding.rvCurrencyList.adapter = adapter

        viewModel.resultCurrencyList.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        binding.ivClose.setOnClickListener {
            adapter.setData(viewModel.getResultList())
            binding.etSearch.text.clear()
            (context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(view?.windowToken, 0)
            toggleEdit()
        }
        binding.ivBack.setOnClickListener {
            adapter.setData(viewModel.getResultList())
            binding.etSearch.text.clear()
            (context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(view?.windowToken, 0)
            toggleEdit()
        }
        binding.ivSearch.setOnClickListener {
            toggleEdit()
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.search(s.toString())
            }
        })
    }

    private fun toggleEdit() {
        viewModel.isEditing.value?.let { viewModel.isEditing.value = !it }
    }
}