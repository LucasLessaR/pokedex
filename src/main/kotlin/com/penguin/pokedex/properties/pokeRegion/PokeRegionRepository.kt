package com.penguin.pokedex.properties.pokeRegion

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface PokeRegionRepository : JpaRepository<PokeRegion, Int>