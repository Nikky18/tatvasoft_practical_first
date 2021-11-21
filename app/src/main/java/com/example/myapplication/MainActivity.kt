package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity()  {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUiComponent()
    }


    private  fun initUiComponent(){

        binding.submitBtn.setOnClickListener {
            val gridNumber = binding.editText.text
            Toast.makeText(this, gridNumber, Toast.LENGTH_SHORT).show()
            binding.editText.setText("")
        }
    }
}