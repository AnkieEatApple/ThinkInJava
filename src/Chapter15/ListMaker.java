package Chapter15;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {

	List<T> create() {
		return new ArrayList<>();
	}

	public static void main(final String[] args) {
		final ListMaker<String> stringMaker = new ListMaker<>();
		final List<String> stringList = stringMaker.create();
	}
}
