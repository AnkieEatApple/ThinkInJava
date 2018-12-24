package Chapter15;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {

	List<T> create(final T t, final int n) {
		final List<T> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(t);
		}

		return result;
	}

	public static void main(final String[] args) {
		final FilledListMaker<String> sFilledListMaker = new FilledListMaker<>();
		final List<String> list = sFilledListMaker.create("Hello", 4);
		System.out.println(list);
	}
}
