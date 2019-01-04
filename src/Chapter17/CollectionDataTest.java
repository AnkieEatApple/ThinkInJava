package Chapter17;

import java.util.LinkedHashSet;
import java.util.Set;

import Chapter15.Generator;

public class CollectionDataTest {

	public static void main(final String[] args) {
		// 这个调用的是一个根据长度添加到set中的列表
		final Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Goverment(), 6));
		System.out.println(set);

		set.addAll(CollectionData.list(new Goverment(), 15));
		System.out.println(set);
	}
}

class Goverment extends Generator<String> {

	String[] foundation = ("strange women lying in ponds " + "distributing swords is no basis for a system of "
			+ "government").split(" ");
	private int index;

	@Override
	public String next() {
		return foundation[index++];
	}
}
