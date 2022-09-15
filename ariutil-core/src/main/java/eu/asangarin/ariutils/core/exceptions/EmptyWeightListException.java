package eu.asangarin.ariutils.core.exceptions;

import java.io.Serial;

/**
 * Thrown when a WeightedContainer tries to select an object while empty.
 */
public class EmptyWeightListException extends Exception {
	@Serial
	private static final long serialVersionUID = 2143864144124510797L;

	/**
	 * Thrown when a WeightedContainer tries to select an object while empty.
	 */
	public EmptyWeightListException() {
		super("Couldn't select weighted object; Weighted List is empty.");
	}
}
