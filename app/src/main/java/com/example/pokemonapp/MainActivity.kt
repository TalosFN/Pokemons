package com.example.pokemonapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonapp.databinding.ActivityMainBinding
import com.example.pokemonapp.repository.PokemonRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        val pokemons = PokemonRepository.getPokemons()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvNext.setOnClickListener {
            val intent = Intent(this, PokemonActivity2::class.java)
            intent.putExtra("id", 1)
            this.startActivity(intent)
            }
        }
    }
