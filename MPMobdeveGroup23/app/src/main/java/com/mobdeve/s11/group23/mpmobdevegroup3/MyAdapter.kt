package com.mobdeve.s11.group23.mpmobdevegroup3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ItemLayoutBinding

class MyAdapter(private val data: ArrayList<Player>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemViewBinding: ItemLayoutBinding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return MyViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(this.data[position])
    }

    override fun getItemCount(): Int {
        return this.data.size
    }
}