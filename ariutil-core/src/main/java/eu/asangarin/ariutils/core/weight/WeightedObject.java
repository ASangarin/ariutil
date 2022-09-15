package eu.asangarin.ariutils.core.weight;

import lombok.Getter;

/**
 * A weighted object.
 * Can be put in a WeightedContainer
 * @param <T> The object type
 */
@Getter
public class WeightedObject<T> {
	private final T object;
	private final int weight;

	/**
	 * Construct a new weighted object.
	 * @param object The object to store
	 * @param w The weight of the object
	 */
	protected WeightedObject(T object, int w) {
		this.object = object;
		this.weight = w;
	}
}
