package eu.asangarin.ariutils.core;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class AriUtils {
	/**
	 * Applies the function if "run" is not null,
	 * or return a default object if it is.
	 */
	public static <T, E> T runOrGet(E run, Function<E, T> func, T object) {
		return run != null ? func.apply(run) : object;
	}

	/**
	 * Accepts the Consumer if "run" is not null
	 */
	public static <T> void runOrVoid(T run, Consumer<T> consumer) {
		if (run != null) consumer.accept(run);
	}

	/**
	 * If a value is null, return the default value
	 */
	public static <T> T getOrDefault(T value, T defaultValue) {
		return value == null ? defaultValue : value;
	}

	/**
	 * Returns a default value if the list.get(index) method fires an IndexOutOfBoundsException
	 */
	public static <T> T getIndexOrDefault(List<T> list, int index, T def) {
		try {
			return list.get(index);
		} catch (IndexOutOfBoundsException e) {
			return def;
		}
	}
}
