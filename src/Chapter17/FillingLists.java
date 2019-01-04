package Chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress {

	private final String string;

	public StringAddress(final String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return super.toString() + " " + string;
	}
}

public class FillingLists {
	public static void main(final String[] args) {

		// nCopies() 方法是创建传递给构造器的list，填充list
		final List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("Hello")));

		System.out.println(list);
		Collections.fill(list, new StringAddress("World!"));
		System.out.println(list);
	}
}
