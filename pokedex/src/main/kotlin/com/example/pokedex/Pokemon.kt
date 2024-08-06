package com.example.pokedex

public class Pokemon(var id: String?, var name: String) {
	fun getPokemonId():String? {return id}
	fun setPokemonId(newId: String) {
		id = newId
	}
}