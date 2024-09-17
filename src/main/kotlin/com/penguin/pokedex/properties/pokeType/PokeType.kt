package com.penguin.pokedex.properties.pokeType

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column

@Entity
@Table(name = "poke_type", schema = "public")
class PokeType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") 
    var id: Int,

    @Column(name = "type_name")
    var typeName: String,
)