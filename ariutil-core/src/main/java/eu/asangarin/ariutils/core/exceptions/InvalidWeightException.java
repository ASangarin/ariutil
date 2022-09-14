package eu.asangarin.ariutils.core.exceptions;

import java.io.Serial;

public class InvalidWeightException extends Exception {
	@Serial
	private static final long serialVersionUID = 2143864144124510797L;

	public InvalidWeightException() {
		super("Invalid weight! Weights must be between 1 and " + Integer.MAX_VALUE);
	}
}
