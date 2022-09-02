package com.example.sumres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope

import com.example.sumres.databinding.ActivityMainBinding

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var tem = 0


        binding.add.setOnClickListener {
            tem++
            rutining()
            binding.counter.text = tem.toString()
        }

        binding.subtract.setOnClickListener {
            tem--
            rutining()
            binding.counter.text = tem.toString()
        }
        binding.counter.text = tem.toString()

    }

    private fun rutining() {
        lifecycleScope.launch {
            binding.add.isEnabled = false
            binding.subtract.isEnabled = false
            binding.progressBar.isVisible = true
            binding.counter.isVisible = false
            delay(1000)
            binding.progressBar.isVisible = false
            binding.counter.isVisible = true
            binding.add.isEnabled = true
            binding.subtract.isEnabled = true
        }
    }


}
