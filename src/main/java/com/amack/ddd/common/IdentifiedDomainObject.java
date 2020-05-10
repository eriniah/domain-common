package com.amack.ddd.common;

/**
 * An object in the domain model that has an identifier
 */
public interface IdentifiedDomainObject
{
	/**
	 * Get the identifier for the object
	 * @return the objects identifier
	 */
	Identifier getId();
}
