package Chapter15;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContainerMethodDifferences {

	static Set<String> methodSet(final Class<?> type) {

		final Set<String> result = new TreeSet<>();
		for (final Method method : type.getMethods()) {
			result.add(method.getName());
		}
		return result;
	}

	static void interfaces(final Class<?> type) {
		System.out.println("Interfaces in " + type.getSimpleName() + ":");
		final List<String> result = new ArrayList<>();
		for (final Class<?> cls : type.getInterfaces()) {
			result.add(cls.getSimpleName());
		}
		System.out.println(result);
	}

	static Set<String> object = methodSet(Object.class);
	static {
		object.add("clone");
	}

	static void difference(final Class<?> superSet, final Class<?> subSet) {
		System.out.println(superSet.getSimpleName() + "extends " + subSet.getSimpleName() + ", adds: ");

		final Set<String> comp = Sets.difference(methodSet(superSet), methodSet(subSet));

		comp.removeAll(object);
		System.out.println(comp);
		interfaces(superSet);
	}

	public static void main(final String[] args) {
		System.out.println("Collection: " + methodSet(Collection.class));

		interfaces(Collection.class);
		difference(Set.class, Collection.class);
	}
}
