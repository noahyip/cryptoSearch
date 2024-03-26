package com.noahyip.cryptotest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.noahyip.cryptotest.R
import com.noahyip.cryptotest.databinding.ActivityDemoBinding
import com.noahyip.cryptotest.viewModel.DemoActivityViewModel

class DemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding
    private lateinit var viewModel: DemoActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
    }
}