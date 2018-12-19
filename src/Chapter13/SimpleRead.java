package Chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead {

	// 这个就是处理了输入流

	public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));

	public static void main(final String[] args) {
		try {
			System.out.println("what is your name?");
			final String name = input.readLine();
			System.out.println(name);
			System.out.println("How old are you? What is your favorite double?");
			System.out.println("(input : <age> <double>)");
			final String numbers = input.readLine();
			System.out.println(numbers);
			final String[] numArray = numbers.split(" ");
			final int age = Integer.parseInt(numArray[0]);
			final double fav = Double.parseDouble(numArray[1]);

			System.out.format("Hi %s.\n", name);
			System.out.format("In 5 years you will be %d.\n", age + 5);
			System.out.format("My favorite double is %f.", fav / 2);
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}
}
