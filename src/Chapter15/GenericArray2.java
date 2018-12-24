package Chapter15;

public class GenericArray2<T> {

	private final Object[] array;

	public GenericArray2(final int sz) {
		array = new Object[sz];
	}

	public void put(final int index, final T item) {
		array[index] = item;
	}

	public T get(final int index) {
		return (T) array[index];
	}

	public T[] rep() {
		return (T[]) array;
	}

	public static void main(final String[] args) {
		final GenericArray2<Integer> gai = new GenericArray2<Integer>(10);

		for (int i = 0; i < 10; i++) {
			gai.put(i, i);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(gai.get(i) + "");
		}

		System.out.println();
		try {
			final Integer[] ia = gai.rep();
		} catch (final Exception e) {
			System.out.println(e);
		}
	}
}
