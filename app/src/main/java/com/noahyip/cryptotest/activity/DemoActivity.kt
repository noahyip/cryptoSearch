package com.noahyip.cryptotest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.noahyip.cryptotest.R
import com.noahyip.cryptotest.databinding.ActivityDemoBinding
import com.noahyip.cryptotest.fragment.CurrencyListFragment
import com.noahyip.cryptotest.viewModel.DemoActivityViewModel
import kotlinx.coroutines.launch

class DemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding
    private lateinit var viewModel: DemoActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[DemoActivityViewModel::class.java]
        binding.viewModel = viewModel

        initView()
    }

    private fun initView() {
        binding.btnClear.setOnClickListener {
            lifecycleScope.launch {
                val success = viewModel.clearData(applicationContext)
                if (success)
                    Toast.makeText(applicationContext, "Data cleared", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(applicationContext, "No Data to clear", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnInsert.setOnClickListener {
            lifecycleScope.launch {
                val success = viewModel.insertData(applicationContext)
                if (success)
                    Toast.makeText(applicationContext, "Data inserted", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSwitchA.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(CurrencyListFragment.CURRENCY_LIST, viewModel.getDataA())
            findNavController(R.id.demo_fragment).navigate(R.id.action_currencyListFragment_self, bundle)
        }

        binding.btnSwitchB.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(CurrencyListFragment.CURRENCY_LIST, viewModel.getDataB())
            findNavController(R.id.demo_fragment).navigate(R.id.action_currencyListFragment_self, bundle)
        }

        binding.btnAll.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(CurrencyListFragment.CURRENCY_LIST, viewModel.getAllData())
            findNavController(R.id.demo_fragment).navigate(R.id.action_currencyListFragment_self, bundle)
        }
    }
}