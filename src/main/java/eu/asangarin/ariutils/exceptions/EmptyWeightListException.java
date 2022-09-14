package eu.asangarin.ariutils.exceptions;

import java.io.Serial;

public class EmptyWeightListException extends Exception {
	@Serial
	private static final long serialVersionUID = 2143864144124510797L;

	public EmptyWeightListException() {
		super("Couldn't select weighted object; Weighted List is empty.");
	}
}
