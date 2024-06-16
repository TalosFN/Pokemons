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
        val pokemonId = intent.getIntExtra("id", -1)
        val pokemon = PokemonRepository.getPokemonById(pokemonId)
        if (pokemon != null) {
            binding.imgPokemon.setImageResource(pokemon.picture)
            binding.tvName.text = pokemon.name
            binding.tvWeight.text = "${pokemon.weight} kg"
            binding.tvHeight.text = "${pokemon.height} cm"
            var types = ""
            for (type in pokemon.elementalType) {
                types += type
                if (type != pokemon.elementalType.last()) {
                    types += ", "
                }
            }
            binding.tvType.text = types
        }
        else {
            Log.e("pokemonIsNull", "Pokemon with ${pokemonId} is not exist")
            binding.imgPokemon.setImageResource(R.drawable.ic_launcher_background)
            binding.tvName.text = "Error"
            binding.tvWeight.text = "Error"
            binding.tvHeight.text = "Error"
            binding.tvType.text = "Error"
        }



        val buttonBack: Button = this.findViewById<Button>(R.id.btn_back)
        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}