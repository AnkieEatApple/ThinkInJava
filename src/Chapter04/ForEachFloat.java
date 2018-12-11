package Chapter04;

import java.util.Random;

public class ForEachFloat {
	public static void main(final String[] args) {
		final Random random = new Random();

		final float f[] = new float[10];
		for (int i = 0; i < 10; i++) {
			f[i] = random.nextFloat();
		}

		System.out.println("============================");

		for (final float x : f) {
			System.out.println(x);
		}
	}
}
