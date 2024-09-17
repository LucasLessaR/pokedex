package com.penguin.pokedex.pokemon

import org.springframework.stereotype.Service

@Service
class PokemonService(private val pokedexRepository: PokedexRepository) {
    fun savePokemon(pokemon: Pokemon): Pokemon = pokedexRepository.save(pokemon)

    fun getPokemonById(id: Int): Pokemon? = pokedexRepository.findById(id).orElse(null)
    
    fun deletePokemonById(id: Int) = pokedexRepository.deleteById(id)
    
    fun getPokemon(): List<Pokemon> = pokedexRepository.findAll()
}