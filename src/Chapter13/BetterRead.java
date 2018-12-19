package Chapter13;

import java.util.Scanner;

public class BetterRead {

	public static void main(final String[] args) {

		final Scanner stdin = new Scanner(SimpleRead.input);
		System.out.println("What is your name?");
		final String name = stdin.nextLine();
		System.out.println(name);
		System.out.println("How old are you? What is your favorite double?");
		System.out.println("(input:<age> <double>)");
		final int age = stdin.nextInt();
		final double fav = stdin.nextDouble();
		System.out.println(age);
		System.out.println(fav);

	}
}
