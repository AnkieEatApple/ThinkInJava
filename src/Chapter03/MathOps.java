package Chapter03;

import java.util.Random;

public class MathOps {

	public static void main(final String[] args) {

		// create random number
		final Random random = new Random(47);

		int i, j, k;
		// choose value from 1 to 100
		j = random.nextInt(100) + 1;
		System.out.println("j :" + j);

		k = random.nextInt(100) + 1;
		System.out.println("k :" + k);

		i = j + k;
		System.out.println("j + k :" + i);

		i = j - k;
		System.out.println("j - k :" + i);

		i = j / k;
		System.out.println("j / k :" + i);

		i = j * k;
		System.out.println("j * k :" + i);

		i = j % k;
		System.out.println("j % k :" + i);

		j %= k;
		System.out.println("j %= k :" + i);

		float u, v, w;
		// float number test
		v = random.nextFloat();
		System.out.println("v :" + v);

		w = random.nextFloat();
		System.out.println("w :" + w);

		u = v + w;
		System.out.println("v + w :" + u);

		u = v - w;
		System.out.println("v - w :" + u);

		u = v * w;
		System.out.println("v * w :" + u);

		u = v / w;
		System.out.println("v / w :" + u);

		// The following also works for char
		// byte, short, int, long, and double
		u += v;
		System.out.println("u += v :" + u);
		u -= v;
		System.out.println("u -= v :" + u);

		u *= v;
		System.out.println("u *= v :" + u);

		u /= v;
		System.out.println("u /= v :" + u);
	}
}
