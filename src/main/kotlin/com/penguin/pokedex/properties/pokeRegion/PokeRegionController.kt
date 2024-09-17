package com.penguin.pokedex.properties.pokeRegion

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Controller
@ResponseBody
@RequestMapping("/pokeRegion")
class PokeRegionController(private val pokeRegionRepository: PokeRegionRepository) {
    @GetMapping("")
    fun getAllRegion(): List<PokeRegion> = 
        pokeRegionRepository.findAll().toList()

    @GetMapping("/{id}")
    fun getRegionById(@PathVariable("id") regionId: Int): ResponseEntity<PokeRegion> {
        val region = pokeRegionRepository.findById(regionId).orElse(null)
        return if (region != null) ResponseEntity(region, HttpStatus.OK)
            else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping("")
    fun createRegion(@RequestBody region: PokeRegion): ResponseEntity<PokeRegion> {
        val createdRegion = pokeRegionRepository.save(region)
        return ResponseEntity(createdRegion, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateUserById(@PathVariable("id") regionId: Int, @RequestBody region: PokeRegion): ResponseEntity<PokeRegion> {
        val existingRegion = pokeRegionRepository.findById(regionId).orElse(null)

        if (existingRegion == null) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        pokeRegionRepository.save(region)
        return ResponseEntity(existingRegion, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteRegionById(@PathVariable("id") regionId: Int): ResponseEntity<PokeRegion> {
        if (!pokeRegionRepository.existsById(regionId)) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        pokeRegionRepository.deleteById(regionId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}