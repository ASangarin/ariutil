package eu.asangarin.ariutils;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Lots of convenience methods for handling enums.
 */
public final class AriEnums {
	/**
	 * Returns a random value from the provided enum class
	 */
	public static <T extends Enum<T>> T getRandomEnum(Class<T> enumClass) {
		if (!enumClass.isEnum()) return null;
		T[] values = enumClass.getEnumConstants();
		return values[AriRandom.get().nextInt(values.length)];
	}

	/**
	 * Cycles to the next value in an enum class
	 */
	public static <T extends Enum<T>> T cycleEnum(Class<T> enumClass, T current) {
		if (current == null || !enumClass.isEnum()) return null;
		T[] values = enumClass.getEnumConstants();
		int next = current.ordinal() + 1;
		if (next >= values.length) return values[0];
		return values[next];
	}

	/**
	 * Gets an enum value corresponding to the given string, if valid.
	 */
	public static <T extends Enum<T>> Optional<T> getOptional(Class<T> enumClass, String value, boolean ignoreCase) {
		return Optional.ofNullable(getOrDefault(enumClass, value, ignoreCase, null));
	}

	/**
	 * Gets an enum value corresponding to the given string, if valid.
	 * Else, return a default value
	 */
	public static <T extends Enum<T>> T getOrDefault(Class<T> enumClass, String value, boolean ignoreCase, T def) {
		if (value == null || !enumClass.isEnum()) return null;
		Predicate<T> predicate = ignoreCase ? a -> a.name().equalsIgnoreCase(value) : a -> a.name().equals(value);
		return Arrays.stream(enumClass.getEnumConstants()).filter(predicate).findFirst().orElse(def);
	}
}
