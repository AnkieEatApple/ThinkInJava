package Chapter04;

public class ForEachInt {
	public static void main(final String[] args) {

		for (final int i : range(10)) {
			System.out.print(i + " ");
		}

		System.out.println();

		for (final int i : range(5, 10)) {
			System.out.print(i + " ");
		}

		System.out.println();

		for (final int i : range(5, 20, 3)) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int[] range(final int i) {
		return range(0, i);
	}

	private static int[] range(final int i, final int k) {
		return range(i, k, 1);
	}

	private static int[] range(final int i, final int k, final int j) {

		final int max = (k - i) / j;
		final int[] ret = new int[max];

		int start = i;
		int n = 0;

		while (n < max && start < k) {
			ret[n] = start;
			n++;
			start += j;
		}
		return ret;
	}

}
