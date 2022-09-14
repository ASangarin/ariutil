package eu.asangarin.ariutils.weight;

import lombok.Getter;

@Getter
public class WeightedObject<T> {
	private final T object;
	private final int weight;
	
	protected WeightedObject(T object, int w) {
		this.object = object;
		this.weight = w;
	}
}
