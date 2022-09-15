package eu.asangarin.ariutils.core;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Lots of convenience methods for handling enums.
 */
public final class AriEnums {
	private AriEnums() {
	}

	/**
	 * Returns a random value from the provided enum class
	 *
	 * @param enumClass The class of the requested Enum
	 * @param <T>       The enum class type
	 * @return A random enum from the given class
	 */
	public static <T extends Enum<T>> T getRandomEnum(Class<T> enumClass) {
		return getRandomEnum(enumClass, AriRandom.get());
	}

	/**
	 * Returns a random value from the provided enum class
	 *
	 * @param enumClass The class of the requested Enum
	 * @param <T>       The enum class type
	 * @param random    The random object to use for randomization
	 * @return A random enum from the given class
	 */
	public static <T extends Enum<T>> T getRandomEnum(Class<T> enumClass, Random random) {
		if (!enumClass.isEnum()) return null;
		T[] values = enumClass.getEnumConstants();
		return values[random.nextInt(values.length)];
	}

	/**
	 * Cycles to the next value in an enum class
	 *
	 * @param enumClass The class of the requested Enum
	 * @param <T>       The enum class type
	 * @param current   The current Enum value
	 * @return The next enum in line
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
	 *
	 * @param enumClass  The class of the requested Enum
	 * @param <T>        The enum class type
	 * @param value      The string to lookup
	 * @param ignoreCase Whether or not case should be ignored
	 * @return Gets an optional containing the enum object or empty if not found.
	 */
	public static <T extends Enum<T>> Optional<T> getOptional(Class<T> enumClass, String value, boolean ignoreCase) {
		return Optional.ofNullable(getOrDefault(enumClass, value, ignoreCase, null));
	}

	/**
	 * Gets an enum value corresponding to the given string, if valid.
	 * Else, return a default value
	 *
	 * @param enumClass  The class of the requested Enum
	 * @param <T>        The enum class type
	 * @param value      The string to lookup
	 * @param ignoreCase Whether or not case should be ignored
	 * @param def        Default value to return if string doesn't exist
	 * @return Gets the enum object if it exists or default value if not.
	 */
	public static <T extends Enum<T>> T getOrDefault(Class<T> enumClass, String value, boolean ignoreCase, T def) {
		if (value == null || !enumClass.isEnum()) return null;
		Predicate<T> predicate = ignoreCase ? a -> a.name().equalsIgnoreCase(value) : a -> a.name().equals(value);
		return Arrays.stream(enumClass.getEnumConstants()).filter(predicate).findFirst().orElse(def);
	}

	/**
	 * Encodes an EnumSet into an int value
	 *
	 * @param set The set to encode
	 * @param <E> The enum type
	 * @return The integer value
	 */
	public static <E extends Enum<E>> int encode(EnumSet<E> set) {
		int ret = 0;

		for (E val : set)
			ret |= (1 << val.ordinal());

		return ret;
	}

	/**
	 * Decodes an int value into an EnumSet
	 *
	 * @param encoded   The encoded value to decode
	 * @param enumKlazz Class of the enum
	 * @param <E>       The enum type
	 * @return A new enumset with the given values
	 */
	public static <E extends Enum<E>> EnumSet<E> decode(int encoded, Class<E> enumKlazz) {
		Map<Integer, E> ordinalMap = new HashMap<>();
		for (E val : EnumSet.allOf(enumKlazz))
			ordinalMap.put(val.ordinal(), val);

		EnumSet<E> ret = EnumSet.noneOf(enumKlazz);
		int ordinal = 0;

		for (int i = 1; i != 0; i <<= 1) {
			if ((i & encoded) != 0) {
				ret.add(ordinalMap.get(ordinal));
			}

			++ordinal;
		}

		return ret;
	}
}
