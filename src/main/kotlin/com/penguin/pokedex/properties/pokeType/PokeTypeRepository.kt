package com.penguin.pokedex.properties.pokeType

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface PokeTypeRepository : JpaRepository<PokeType, Int>