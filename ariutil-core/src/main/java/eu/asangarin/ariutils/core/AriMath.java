package eu.asangarin.ariutils.core;

/**
 * Quick and convenient Math utilities
 */
public final class AriMath {
	private AriMath() {
	}

	/**
	 * Returns a value inbetween 0.0 and 1.0, depending
	 * on the relation between the value, max and min value.
	 *
	 * @param value The current value
	 * @param max   The maximum value
	 * @param min   The minimum value
	 * @return A value between 0.0 and 1.0, depending on the relation between "value", "max" and "min"
	 */
	public static float normalize(float value, float max, float min) {
		return (value - min) / (max - min);
	}
}
