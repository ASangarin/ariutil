package eu.asangarin.ariutils;

import java.util.Random;

public final class AriRandom {
	private static final Random RANDOM = new Random();

	public static Random get() {
		return RANDOM;
	}
}
