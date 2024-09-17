package com.penguin.pokedex.pokemon

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column

@Entity
@Table(name = "pokemon", schema = "public")
class Pokemon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") 
    var id: Int,

    @Column(name = "pokemon_name")
    var pokemonName: String,

    @Column(name = "type")
    var type_id: Int,

    @Column(name = "region")
    var region_id: Int
)