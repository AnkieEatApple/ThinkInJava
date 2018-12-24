package Chapter15;

public class InstantiateGenericType {
	public static void main(final String[] args) {
		final ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
		System.out.println("ClassAsFactory<Employee> succeeded");
		try {
			final ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
		} catch (final Exception e) {
			System.out.println("ClassAsFactory<Integer> failed");
		}
	}
}

class ClassAsFactory<T> {
	T x;

	public ClassAsFactory(final Class<T> kind) {
		try {
			x = kind.newInstance();
		} catch (final Exception e) {
			throw new RuntimeException();
		}
	}
}

class Employee {
}
