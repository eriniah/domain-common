package com.amack.ddd.common;

/**
 * Identifies an object in the domain model
 */
public interface Identifier
{
	/**
	 * Get the id as a string
	 * @return the id as a string
	 */
	String getId();
}
