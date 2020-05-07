package com.amack.domain.common;

/**
 * An object in the domain model that has an identifier
 */
public interface IdentifiedDomainObject
{
	/**
	 * Get the identifier for the object
	 * @return the objects identifier
	 */
	AbstractIdentifier getId();
}
