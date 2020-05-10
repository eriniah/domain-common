package com.amack.ddd.common

/**
 * Factory for creating domain object instances for tests
 */
class TestFactory
{

	static AbstractIdentifier newId() {
		return new AbstractIdentifier(UUID.randomUUID().toString()){}
	}

	static AbstractIdentifier newId(String id) {
		return new AbstractIdentifier(id){}
	}

	static Entity<Identifier> entity()
	{
		return new TestEntity()
	}

	static Entity<Identifier> entity(Identifier identifier)
	{
		return new TestEntity(identifier)
	}

	static class TestEntity extends Entity<Identifier>
	{
		TestEntity()
		{
		}

		TestEntity(Identifier id)
		{
			super(id);
		}
	}

}
