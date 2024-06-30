package com.example.pokemonapp.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.pokemonapp.model.Pokemon

object DiffCallback : DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon) =
        oldItem == newItem


}