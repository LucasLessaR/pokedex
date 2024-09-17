package com.penguin.pokedex.pokemon

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface PokedexRepository : JpaRepository<Pokemon, Int>