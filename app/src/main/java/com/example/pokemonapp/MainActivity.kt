package com.example.pokemonapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.pokemonapp.databinding.ActivityMainBinding
import com.example.pokemonapp.repository.PokemonRepository
import com.example.pokemonapp.rv.PokemonListAdapter
import androidx.recyclerview.widget.RecyclerView.VERTICAL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val pokemons = PokemonRepository.getPokemons()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = PokemonListAdapter()
        adapter.onClick = { pokemon ->
            val intent = Intent(this@MainActivity, PokemonActivity2::class.java).apply {
                putExtra("id", pokemon.id)
            }
            startActivity(intent)
        }
        binding.main.adapter = adapter
        adapter.submit(PokemonRepository.getPokemons())
        binding.main.addItemDecoration(DividerItemDecoration(this, VERTICAL))
    }
}

