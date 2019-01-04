package Chapter17;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TypesForSets {

	static <T> Set<T> fill(final Set<T> set, final Class<T> type) {
		try {
			for (int i = 0; i < 10; i++) {
				set.add(type.getConstructor(int.class).newInstance(i));
//				if (i == 9) {
//					System.out.println("9 : " + type.getConstructor(int.class).newInstance(i));
//				}
			}
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		return set;
	}

	static <T> void test(final Set<T> set, final Class<T> type) {
		// fill three times for test set's elements is repetiton or not;
		fill(set, type);
		fill(set, type);
		fill(set, type);
		System.out.println(set);
	}

	public static void main(final String[] args) {
		test(new HashSet<>(), HashType.class);
		test(new LinkedHashSet<>(), HashType.class);
		test(new TreeSet<>(), TreeType.class);
		// things that don't work
		test(new HashSet<>(), SetType.class);
		test(new HashSet<>(), TreeType.class);
		test(new LinkedHashSet<>(), SetType.class);
		test(new LinkedHashSet<>(), TreeType.class);
		try {
			test(new TreeSet<>(), SetType.class);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			test(new TreeSet<>(), HashType.class);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class SetType {
	int i;

	public SetType(final int n) {
		this.i = n;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof SetType && (i == ((SetType) obj).i);
	}

	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

class HashType extends SetType {
	public HashType(final int n) {
		super(n);
	}

	@Override
	public int hashCode() {
		return i;
	}
}

class TreeType extends SetType implements Comparable<TreeType> {
	public TreeType(final int n) {
		super(n);
	}

	@Override
	public int compareTo(final TreeType arg) {
		return (arg.i < i ? -1 : (arg.i == i ? 0 : 1));
	}
}
