package com.example.pokedex

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import org.springframework.web.bind.annotation.*

@SpringBootApplication
class PokedexApplication

data class Person(var id: String?, var name: String) {
	fun getPersonId():String? {return id}
	fun setPersonId(newId: String) {
		id = newId
	}
}

fun main(args: Array<String>) {
	runApplication<PokedexApplication>(*args)
}

@RestController
class MessageController {
	var people:Array<Person> = arrayOf(Person("1", "Ana"),
		Person("2", "Beto"),
		Person("3", "Carlos"),
		)

	fun getLastId(): String {
		var lastId: String? = people.last().getPersonId()
		lastId = if (lastId != null) lastId else "0"
		var newId = lastId.toInt() + 1
		return newId.toString()
	}

    @GetMapping("/")
    fun getAllPeople(): Array<Person> = people

	@PostMapping("/")
    fun addPerson(@RequestBody person: Person): Array<Person> {
		val newId:String = getLastId()
		person.setPersonId(newId) 
		people += person
		return people
	}

}