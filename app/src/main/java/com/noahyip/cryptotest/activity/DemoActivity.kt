package com.noahyip.cryptotest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.noahyip.cryptotest.R
import com.noahyip.cryptotest.databinding.ActivityDemoBinding
import com.noahyip.cryptotest.viewModel.DemoActivityViewModel

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

        }
        binding.btnInsert.setOnClickListener {

        }
        binding.btnSwitchA.setOnClickListener {

        }
        binding.btnSwitchB.setOnClickListener {

        }
        binding.btnAll.setOnClickListener {

        }
    }
}