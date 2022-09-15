package eu.asangarin.ariutils.core;

import java.util.Arrays;

/**
 * A few utilities focusing on Strings
 */
public final class AriStrings {
	private AriStrings() {
	}

	/**
	 * Capitalizes the first letter
	 *
	 * @param str The string to capitalize
	 * @return The capitalized string
	 */
	public static String capitalizeFirst(String str) {
		if (str == null || str.isEmpty()) return "";
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * Capitalizes every word
	 *
	 * @param str The string to capitalize
	 * @return The capitalized string
	 */
	public static String capitalizeWords(String str) {
		if (str == null || str.isEmpty()) return "";
		String[] split = str.split(" ");

		StringBuilder builder = new StringBuilder();
		for (String s : split) {
			builder.append(capitalizeFirst(s));
			builder.append(" ");
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}

	/**
	 * Wraps a character around a string
	 *
	 * @param character The character to wrap the string in
	 * @param str       The string to wrap
	 * @return The newly wrapped string
	 */
	public static String wrap(char character, String str) {
		return character + str + character;
	}

	/**
	 * Checks if the string equals ANY of the supplied strings
	 *
	 * @param compare The string to compare
	 * @param strings The strings to compare against
	 * @return Whether or not a string was equal
	 */
	public static boolean equalsAny(String compare, String... strings) {
		return Arrays.asList(strings).contains(compare);
	}

	/**
	 * Checks if the string equals ANY of the supplied strings (case ignored)
	 *
	 * @param compare The string to  (case ignored)
	 * @param strings The strings to compare against (case ignored)
	 * @return Whether or not a string was equal (case ignored)
	 */
	public static boolean equalsAnyIgnoreCase(String compare, String... strings) {
		return Arrays.stream(strings).anyMatch(str -> str.equalsIgnoreCase(compare));
	}
}
