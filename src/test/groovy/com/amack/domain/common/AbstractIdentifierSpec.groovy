package com.amack.domain.common

import spock.lang.Specification

class AbstractIdentifierSpec
		extends Specification
{

	def "Id is set"()
	{
		given:
		String value = "test value";

		when:
		AbstractIdentifier id = new TestIdentifier(value);

		then:
		null != id.getId();
		value == id.getId();
	}

	static class TestIdentifier extends AbstractIdentifier
	{
		TestIdentifier(String id)
		{
			super(id)
		}
	}

}
