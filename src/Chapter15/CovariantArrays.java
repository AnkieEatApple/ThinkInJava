package Chapter15;

public class CovariantArrays {
	public static void main(final String[] args) {
		final Friut[] friuts = new Apple[10];
		friuts[0] = new Apple();
		friuts[1] = new Jonathan();

		try {
			friuts[0] = new Friut();
		} catch (final Exception e) {
			System.out.println(e);
		}

		try {
			friuts[0] = new Orange();
		} catch (final Exception e) {
			System.out.println(e);
		}
	}
}

class Friut {
}

class Apple extends Friut {
}

class Jonathan extends Apple {
}

class Orange extends Friut {
}
