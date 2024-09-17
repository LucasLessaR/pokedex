package com.penguin.pokedex.properties.pokeType

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
@RequestMapping("/pokeType")
class PokeTypeController(private val pokeTypeRepository: PokeTypeRepository) {
    @GetMapping("")
    fun getAllType(): List<PokeType> = 
        pokeTypeRepository.findAll().toList()

    @GetMapping("/{id}")
    fun getTypeById(@PathVariable("id") typeId: Int): ResponseEntity<PokeType> {
        val type = pokeTypeRepository.findById(typeId).orElse(null)
        return if (type != null) ResponseEntity(type, HttpStatus.OK)
            else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping("")
    fun createType(@RequestBody type: PokeType): ResponseEntity<PokeType> {
        val createdType = pokeTypeRepository.save(type)
        return ResponseEntity(createdType, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateUserById(@PathVariable("id") typeId: Int, @RequestBody type: PokeType): ResponseEntity<PokeType> {
        val existingType = pokeTypeRepository.findById(typeId).orElse(null)

        if (existingType == null) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        pokeTypeRepository.save(type)
        return ResponseEntity(existingType, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteTypeById(@PathVariable("id") typeId: Int): ResponseEntity<PokeType> {
        if (!pokeTypeRepository.existsById(typeId)) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        pokeTypeRepository.deleteById(typeId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}