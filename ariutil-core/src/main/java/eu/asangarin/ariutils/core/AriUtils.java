package eu.asangarin.ariutils.core;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Contains some niche little methods
 */
public final class AriUtils {
	private AriUtils() {
	}

	/**
	 * Applies the function if "run" is not null,
	 * or return a default object if it is.
	 *
	 * @param run The object to "apply"
	 * @param func The function to apply.
	 * @param object Default object to return if "run" is null.
	 * @param <T> Returned object generic
	 * @param <E> Function apply generic
	 * @return Default if "run" is null, function return if not.
	 */
	public static <T, E> T runOrGet(E run, Function<E, T> func, T object) {
		return run != null ? func.apply(run) : object;
	}

	/**
	 * Accepts the Consumer if "run" is not null
	 *
	 * @param run      The object to "consume"
	 * @param consumer The consumer to accept.
	 * @param <T> Type of object / Consumer generic
	 */
	public static <T> void runOrVoid(T run, Consumer<T> consumer) {
		if (run != null) consumer.accept(run);
	}

	/**
	 * If a value is null, return the default value
	 *
	 * @param value        The value to check against
	 * @param defaultValue The value to return if value is null.
	 * @param <T> The object type
	 * @return The value or default if it's null
	 */
	public static <T> T getOrDefault(T value, T defaultValue) {
		return value == null ? defaultValue : value;
	}

	/**
	 * Returns a default value if the list.get(index) method fires an IndexOutOfBoundsException
	 *
	 * @param list  The list to get from.
	 * @param index The index of the object in the list.
	 * @param def   The object to return if the index is out of bounds.
	 * @param <T>   List generic
	 * @return Either the object in the list or default if not found
	 */
	public static <T> T getIndexOrDefault(List<T> list, int index, T def) {
		try {
			return list.get(index);
		} catch (IndexOutOfBoundsException e) {
			return def;
		}
	}
}
