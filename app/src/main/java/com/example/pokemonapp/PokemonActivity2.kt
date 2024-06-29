package com.example.pokemonapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonapp.databinding.ActivityPokemon2Binding
import com.example.pokemonapp.repository.PokemonRepository

class PokemonActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityPokemon2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon2)

        binding = ActivityPokemon2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val pokemonId = intent.getIntExtra("id", 1)
        val pokemon = PokemonRepository.getPokemonById(pokemonId)
        pokemon?.let {
            binding.apply {
                imgPokemon.setImageResource(it.picture)
                tvName.text = it.name
                tvWeight.text = "${it.weight} kg"
                tvHeight.text = "${it.height} sm"
                tvType.text = it.elementalType.joinToString(", ")
            }
        } ?: run {
            Log.e("pokemonIsNull", "Pokemon with $pokemonId does not exist")
            binding.apply {
                imgPokemon.setImageResource(R.drawable.ic_launcher_background)
                tvName.text = "Error"
                tvWeight.text = "Error"
                tvHeight.text = "Error"
                tvType.text = "Error"
            }
        }


        val buttonBack: Button = this.findViewById<Button>(R.id.btn_back)
        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}