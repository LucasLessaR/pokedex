package com.example.pokedex

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import org.springframework.web.bind.annotation.*

import com.example.pokedex.Pokemon
import com.example.pokedex.PokemonController

@SpringBootApplication
class PokedexApplication

fun main(args: Array<String>) {
	runApplication<PokedexApplication>(*args)
}