package Chapter05;

public class PassingThis {

	static class Person {
		public void eat(final Apple apple) {
			final Apple peeled = apple.getPeeled();
			System.out.println("Yummy");
		}
	}

	static class Peeler {
		static Apple peel(final Apple apple) {
			// ... remove peel
			return apple;
		}
	}

	static class Apple {
		Apple getPeeled() {
			return Peeler.peel(this);
		}
	}

	public static void main(final String[] args) {
		new Person().eat(new Apple());
	}
}
