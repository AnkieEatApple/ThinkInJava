package Chapter15;

import java.util.ArrayList;
import java.util.List;

public class ListOfGenerics<T> {

	private final List<T> array = new ArrayList<>();

	public void add(final T item) {
		array.add(item);
	}

	public T get(final int index) {
		return array.get(index);
	}
}
