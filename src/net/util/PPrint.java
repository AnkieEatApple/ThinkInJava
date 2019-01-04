package net.util;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
	public static String pformat(final Collection<?> c) {
		if (c.size() == 0) {
			return "[]";
		}
		final StringBuilder result = new StringBuilder("[");
		for (final Object element : c) {
			if (c.size() != 1) {
				result.append("\n");
			}
			result.append(element);
		}
		if (c.size() != 1) {
			result.append("\n");
		}
		result.append("]");
		return result.toString();
	}

	public static void pprint(final Collection<?> c) {
		System.out.println(pformat(c));
	}

	public static void pprint(final Object[] c) {
		System.out.println(pformat(Arrays.asList(c)));
	}
}
