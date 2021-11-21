package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.GridItemBinding

class GridRecyclerView(val cardHeight: Int): ListAdapter<GridRecyclerView.ViewHolder>(){

      fun  onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GridItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false), cardHeight
        )
    }

     fun onBindViewHolder(holder: ViewHolder, position: Int){
            let{
                with(holder){
                    itemView.tag = this
                    bind()
                }
            }
    }


    class ViewHolder(private val binding: GridItemBinding, private val height: Int) : RecyclerView.ViewHolder(binding.root){
        fun bind(){
            binding.layout.layoutParams.height = height
        }

    }
}
