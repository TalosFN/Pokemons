package com.example.pokemonapp.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.model.Pokemon

class PokemonListAdapter : RecyclerView.Adapter<PokemonViewHolder>() {


    private var items = emptyList<Pokemon>()
    private val differ = AsyncListDiffer(this, DiffCallback)
    var onClick: (Pokemon) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }

    fun submit(newItems: List<Pokemon>) {
        items = newItems
        differ.submitList(newItems)
    }

}