package Chapter13;

import java.util.Random;

public class UsingStringBuilder {

	public static Random random = new Random(47);

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < 25; i++) {
			result.append(random.nextInt(100));
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("]");
		return result.toString();
	}

	public static void main(final String[] args) {
		final UsingStringBuilder usingStringBuilder = new UsingStringBuilder();
		System.out.println(usingStringBuilder);
	}
}
