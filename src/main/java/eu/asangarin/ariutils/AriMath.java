package eu.asangarin.ariutils;

/**
 * Quick and convenient Math utilities
 */
public final class AriMath {
	/**
	 * Returns a value inbetween 0.0 and 1.0, depending
	 * on the relation between the value, max and min value.
	 */
	public static float normalize(float value, float max, float min) {
		return (value - min) / (max - min);
	}
}
