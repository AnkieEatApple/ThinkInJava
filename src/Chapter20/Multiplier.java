package Chapter20;

@ExtractInterface("IMultiplier")
public class Multiplier {
	public int multiply(final int x, final int y) {
		int total = 0;
		for (int i = 0; i < x; i++) {
			total = add(total, y);
		}
		return total;

	}

	private int add(final int x, final int y) {
		return x + y;
	}

	public static void main(final String[] args) {
		final Multiplier multiplier = new Multiplier();
		System.out.println("11*16 = " + multiplier.multiply(11, 16));
	}
}
