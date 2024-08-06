package com.example.pokedex

import org.springframework.web.bind.annotation.*

@RestController
class PokemonController {
	var pokedex:Array<Pokemon> = arrayOf(Pokemon("1", "Bulbasaur"),
		Pokemon("2", "Charmander"),
		Pokemon("3", "Squirtle"),
		)

	fun getLastId(): String {
		var lastId: String? = pokedex.last().getPokemonId()
		lastId = if (lastId != null) lastId else "0"
		var newId = lastId.toInt() + 1
		return newId.toString()
	}

    @GetMapping("/")
    // fun getAllPeople(): Array<Pokemon> = pokedex
    fun getAllPeople(): Array<Pokemon> {
        return pokedex
    }

	@PostMapping("/")
    fun addPerson(@RequestBody pokemon: Pokemon): Array<Pokemon> {
		val newId:String = getLastId()
		pokemon.setPokemonId(newId) 
		pokedex += pokemon
		return pokedex
	}

}