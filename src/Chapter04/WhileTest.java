package Chapter04;

public class WhileTest {

	static boolean condition() {
		final boolean result = Math.random() < 0.99;
		System.out.println(result + ", ");
		return result;
	}

	public static void main(final String[] args) {
		while (condition()) {
			System.out.println("Inside 'while'");
		}

		System.out.println("Exit 'while'");
	}
}
