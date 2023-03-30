package com.mobdeve.s11.group23.mpmobdevegroup3

import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.s11.group23.mpmobdevegroup3.databinding.ItemLayoutBinding

class MyViewHolder(private val viewBinding: ItemLayoutBinding): RecyclerView.ViewHolder(viewBinding.root) {
    fun bindData(model: Player) {
        this.viewBinding.Username.text = model.username
        this.viewBinding.Wins.text = model.wins.toString()
    }
}