package com.example.pokemonapp.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.model.Pokemon

class PokemonViewHolder (
    private val binding: ItemPokemonBinding
): RecyclerView.ViewHolder(binding.root){
    fun bind(model: Pokemon, onClick: (Pokemon)-> Unit) {

            binding.tvPokemonName.text = model.name
            binding.root.setOnClickListener {onClick(model)}

    }
}