package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
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
            var gridNumber = binding.editText.text.toString().toDouble()
            Toast.makeText(this, "$gridNumber", Toast.LENGTH_SHORT).show()
            binding.editText.setText("")

            val gridLayoutNumber = checkValidation(gridNumber)
            Toast.makeText(this, "${gridLayoutNumber}", Toast.LENGTH_SHORT).show()
        }
    }


    private fun checkValidation(gridNumber: Double): Double{
        val square = Math.sqrt(gridNumber)
        val florValue = Math.floor(square)
        return if(square == florValue) florValue else 0.0
    }
}