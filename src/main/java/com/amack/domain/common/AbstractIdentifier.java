package com.amack.domain.common;

import java.util.Objects;

/**
 * A common String based implementation of the Identifier interface
 */
public abstract class AbstractIdentifier implements Identifier
{
	private String id;

	public AbstractIdentifier(String id)
	{
		setId(id);
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
		AbstractIdentifier that = (AbstractIdentifier) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}

	@Override
	public String toString()
	{
		return id;
	}

	@Override
	public String getId()
	{
		return id;
	}

	private void setId(String id)
	{
		this.id = id.trim();
	}

}
