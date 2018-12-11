package Chapter05;

public class Overloadingorder {

	static void f(final String s, final int i) {
		System.out.println("String :" + s + ", int: " + i);
	}

	static void f(final int i, final String s) {

		System.out.println("int : " + i + ", String: " + s);
	}

	public static void main(final String[] args) {
		f("String first", 11);
		f(99, "Int first");
	}
}
