package com.example.pokemonapp.repository

import com.example.pokemonapp.model.Pokemon
import com.example.pokemonapp.R
object PokemonRepository {
    private val pokemons: HashMap<Int, Pokemon> = HashMap(listOf(
        Pokemon(
            id = 1,
            name = "Bulbasaur",
            weight = 69,
            height = 7,
            elementalType = listOf("Grass","Poison"),
            picture = R.drawable.bulbasaur
        ),
        Pokemon(
            id = 2,
            name = "Ivysaur",
            weight = 130,
            height = 10,
            elementalType = listOf("Grass","Poison"),
            picture = R.drawable.ivysaur
        ),
        Pokemon(
            id = 3,
            name = "Venusaur",
            weight = 1000,
            height = 20,
            elementalType = listOf("Grass","Poison"),
            picture = R.drawable.venusaur
        ),
        Pokemon(
            id = 4,
            name = "Charmander",
            weight = 85,
            height = 6,
            elementalType = listOf("Fire"),
            picture = R.drawable.charmander
        ),
        Pokemon(
            id = 5,
            name = "Charmeleon",
            weight = 190,
            height = 11,
            elementalType = listOf("Fire"),
            picture = R.drawable.charmelion
        )
    ).associateBy { it.id })

    fun getPokemons(): HashMap<Int, Pokemon> {
        return pokemons
    }
    fun getPokemonById(Id: Int): Pokemon?{
        return pokemons[Id]
    }

}