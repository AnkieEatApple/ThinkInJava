package Chapter15;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {

	private final Class<T> kind;

	public ArrayMaker(final Class<T> kind) {
		this.kind = kind;
	}

	T[] create(final int size) {
		return (T[]) Array.newInstance(kind, size);
	}

	public static void main(final String[] args) {
		final ArrayMaker<String> sArrayMaker = new ArrayMaker<>(String.class);
		final String[] strings = sArrayMaker.create(9);
		System.out.println(Arrays.toString(strings));
	}
}
