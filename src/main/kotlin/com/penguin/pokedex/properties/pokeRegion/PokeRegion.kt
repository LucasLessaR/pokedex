package com.penguin.pokedex.properties.pokeRegion

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column

@Entity
@Table(name = "poke_region", schema = "public")
class PokeRegion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") 
    var id: Int,

    @Column(name = "region_name")
    var regionName: String,
)