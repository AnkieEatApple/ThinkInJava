package Chapter15;

import java.util.Collection;

public class Generators {

	public static <T> Collection<T> fill(final Collection<T> coll, final Generator<T> gen, final int n) {
		for (int i = 0; i < n; i++) {
			coll.add(gen.next());
		}
		return coll;
	}

	public static void main(final String[] args) {

	}
}
