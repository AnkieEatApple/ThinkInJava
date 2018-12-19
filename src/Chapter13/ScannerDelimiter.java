package Chapter13;

import java.util.Scanner;

public class ScannerDelimiter {

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner("12, 42, 78, 99, 42");

		scanner.useDelimiter("\\s*,\\s*");
		while (scanner.hasNextInt())
			System.out.println(scanner.nextInt());
	}
}

/*
 * useDelimiter 来设置定界符，同时还有一个delimiter方法
 * 
 * 
 * 
 * 
 */
