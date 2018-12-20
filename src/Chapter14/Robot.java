package Chapter14;

import java.util.List;

public interface Robot {

	String name();

	String model();

	List<Operation> operations();

	class Test {
		public static void test(final Robot t) {
			if (t instanceof Null) {
				System.out.println("[Null Robot]");
			}

			System.out.println("Robot name " + t.name());
			System.out.println("Robot model : " + t.model());

			for (final Operation operation : t.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
		}
	}
}
