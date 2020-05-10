package com.amack.ddd.common


import spock.lang.Specification
import spock.lang.Unroll
import static com.amack.ddd.common.TestFactory.newId;

class AbstractIdentifierSpec
		extends Specification
{

	def "Create identifier"()
	{
		String value = "test"

		when:
		AbstractIdentifier id = newId(value)

		then:
		value == id.id
		value == id.toString()
	}

	def "Create identifier with null id"() {
		String value = null

		when:
		AbstractIdentifier id = newId(value)

		then:
		thrown NullPointerException
	}

	def "Create identifier with empty id"() {
		String value = '  '

		when:
		AbstractIdentifier id = newId(value)

		then:
		thrown NullPointerException
	}

	@Unroll
	def "#a == #b is #result"() {

		expect:
		// Leave as .equals since '==' in groovy conditionally calls compareTo() instead or equals()
		a.equals(b) == result
		a.hashCode() == b?.hashCode() == result

		where:
		a			| b					|| result
		newId('a')	| a					|| true
		newId('a')	| newId('a')		|| true
		newId('a')	| newId('b')		|| false
		newId('a')	| new Object()		|| false
		newId('a')	| null				|| false
	}

}
