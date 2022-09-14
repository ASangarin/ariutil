package eu.asangarin.ariutils;

import java.util.Arrays;

/**
 *
 */
public final class AriStrings {
	/**
	 * Capitalizes the first letter
	 */
	public static String capitalizeFirst(String str) {
		if (str == null || str.isEmpty()) return "";
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * Capitalizes every word
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
	 */
	public static String wrap(char character, String str) {
		return character + str + character;
	}

	public static boolean equalsAny(String compare, String... strings) {
		return Arrays.asList(strings).contains(compare);
	}

	public static boolean equalsAnyIgnoreCase(String compare, String... strings) {
		return Arrays.stream(strings).anyMatch(str -> str.equalsIgnoreCase(compare));
	}
}
