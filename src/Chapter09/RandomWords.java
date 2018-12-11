package Chapter09;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {

	//
	private static Random rand = new Random(47);

	//
	private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	//
	private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	//
	private static final char[] vowels = "aeiou".toCharArray();

	//
	private int count;

	public RandomWords(final int count) {
		this.count = count;
	}

	@Override
	public int read(final CharBuffer cb) throws IOException {
		//
		if (count-- == 0) {
			return -1;
		}
		cb.append(capitals[rand.nextInt(capitals.length)]);
		for (int i = 0; i < 4; i++) {
			cb.append(vowels[rand.nextInt(vowels.length)]);
			cb.append(lowers[rand.nextInt(lowers.length)]);
		}
		cb.append(" ");
		return 10;
	}

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(new RandomWords(10));
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
	}
}
