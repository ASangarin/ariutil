package eu.asangarin.ariutils.core;

import java.util.Random;

/**
 * A static random instance.
 * WARNING, this isn't a good way to go about this.
 * This class merely exists for random operations where
 * the outcome isn't very important.
 * <p>
 * Author Comment:
 * "I have no idea what I'm doing, this class is a representation of that."
 */
public final class AriRandom {
	private AriRandom() {
	}

	private static final Random RANDOM = new Random();

	/**
	 * Get a static instance of a Random object
	 *
	 * @return A random object
	 */
	public static Random get() {
		return RANDOM;
	}
}
