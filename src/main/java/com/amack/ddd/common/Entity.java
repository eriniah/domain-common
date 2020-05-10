package com.amack.ddd.common;

import java.util.Objects;

/**
 * An Entity in the domain
 * @param <Id> the type of identifier for the entity
 */
public abstract class Entity<Id extends Identifier> implements IdentifiedDomainObject
{
	private Id id;

	protected Entity()
	{
	}

	protected Entity(Id id)
	{
		this.id = id;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		Entity<?> entity = (Entity<?>) o;
		return Objects.equals(id, entity.id);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}

	@Override
	public String toString()
	{
		return "Entity{" +
		"id=" + id +
		'}';
	}

	/**
	 * Get the entities identifier
	 * @return the identifier for this entity
	 */
	@Override
	public Id getId()
	{
		return id;
	}

	/**
	 * Set the identifier for this object to a new identifier
	 * @param id the object identifier
	 */
	public void setId(Id id)
	{
		this.id = id;
	}

}
