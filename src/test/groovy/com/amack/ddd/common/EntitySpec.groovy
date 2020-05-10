package com.amack.ddd.common

import spock.lang.Specification
import spock.lang.Unroll

import static com.amack.ddd.common.TestFactory.entity
import static com.amack.ddd.common.TestFactory.newId

class EntitySpec extends Specification
{

	def "Create an Entity without an id"() {
		Entity<Identifier> entity = entity()

		expect:
		entity.id == null
	}

	def "Create an Entity with an id"() {
		Identifier id = newId()
		Entity<Identifier> entity = entity(id)

		expect:
		entity.id == id
	}

	def "Set Entity id"() {
		Entity<Identifier> entity = entity(newId())
		Identifier id = newId()

		when:
		entity.id = id

		then:
		entity.id == id
	}

	def "Set Entity id to null"() {
		Entity<Identifier> entity = entity(newId())

		when:
		entity.id = null

		then:
		!entity.id
	}

	def "Entity to String"() {
		Identifier id = newId()
		Entity<Identifier> entity = entity(id)

		expect:
		entity.toString().contains(id.toString())
	}

	@Unroll
	def "#a == #b is #result"() {

		expect:
		// Leave as .equals since '==' in groovy conditionally calls compareTo() instead or equals()
		a.equals(b) == result
		a.hashCode() == b?.hashCode() == result

		where:
		a					| b						|| result
		entity(newId('a'))	| a						|| true
		entity(newId('a'))	| entity(newId('a'))	|| true
		entity(newId('a'))	| entity(newId('b'))	|| false
		entity(newId('a'))	| new Object()			|| false
		entity(newId('a'))	| null					|| false
	}

}
