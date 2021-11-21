package com.example.myapplication

import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.GridRecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {

    lateinit var binding: ActivityMainBinding
    var rowAndColumn = 0


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

            if(gridLayoutNumber != 0.0){
                rowAndColumn = gridLayoutNumber.toInt()
                drawGrid()
            }
        }
    }

    private fun drawGrid(){
        binding.layout.viewTreeObserver.addOnGlobalLayoutListener(
            object : ViewTreeObserver.OnGlobalLayoutListener{
                override fun onGlobalLayout() {
                    val frameLayout = binding.layout.measuredHeight
                    val editContainer = binding.editTextContainer.height
                    val cardHeight = (frameLayout - editContainer) / rowAndColumn

                    binding.grid.viewTreeObserver.removeOnGlobalLayoutListener(this)

                    var adapter = GridRecyclerView(cardHeight)
                    drawCard(cardHeight)
                }
            }
        )
    }

    private fun drawCard(cardHeight:Int){
        binding.grid.layoutManager = GridLayoutManager(this, rowAndColumn)
    }
    private fun checkValidation(gridNumber: Double): Double{
        val square = Math.sqrt(gridNumber)
        val florValue = Math.floor(square)
        return if(square == florValue) florValue else 0.0
    }

}