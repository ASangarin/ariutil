package eu.asangarin.ariutils.core.exceptions;

import java.io.Serial;

/**
 * Thrown when a weight is lower than 1 or Integer.MAX_VALUE
 */
public class InvalidWeightException extends Exception {
	@Serial
	private static final long serialVersionUID = 2143864144124510797L;

	/**
	 * Thrown when a weight is lower than 1 or Integer.MAX_VALUE
	 */
	public InvalidWeightException() {
		super("Invalid weight! Weights must be between 1 and " + Integer.MAX_VALUE);
	}
}
