package com.example.hw4_m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.hw4_m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnGetLove.setOnClickListener {
                viewModel.getLiveLoveData(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(this@MainActivity, Observer {
                        tvResult.text = it.toString()
                    })
            }
        }
    }
}