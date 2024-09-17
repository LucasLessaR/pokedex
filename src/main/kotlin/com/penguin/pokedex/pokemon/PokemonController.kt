package com.penguin.pokedex.pokemon

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus

@Controller
@ResponseBody
@RequestMapping("/pokemon")
class PokedexController(private val pokedexService: PokemonService) {
    @RequestMapping(method = [RequestMethod.POST, RequestMethod.PUT])
    fun writePokemon(@RequestBody pokemon: Pokemon): Pokemon = pokedexService.savePokemon(pokemon)

    @GetMapping("")
    fun getAllPokemon(): List<Pokemon> = pokedexService.getPokemon().toList()

    @GetMapping("/{id}")
    fun getPokemonById(@PathVariable id: Int): Pokemon =
        pokedexService.getPokemonById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "No pokemon found for $id")

    @DeleteMapping("/{id}")
    fun deletePokemonById(@PathVariable id: Int) = pokedexService.deletePokemonById(id)
}