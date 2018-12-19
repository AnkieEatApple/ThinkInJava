package Chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {

	private static String usage = "usage:\n" + "showMethods qualified in class or:\\n"
			+ "To show all methods in class or:\\n" + "ShowMethods qualified class name word\n"
			+ "To search for methods involving word";

	private static Pattern pattern = Pattern.compile("\\w+\\.");

	public static void main(final String[] args) {
		if (args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}

		int lines = 0;

		Class<?> c;
		try {
			c = Class.forName(args[0]);
			final Method[] methods = c.getMethods();

			final Constructor[] constructors = c.getConstructors();
			if (args.length == 1) {
				for (final Method method : methods) {
					System.out.println(pattern.matcher(method.toString()).replaceAll(""));
				}
				for (final Constructor constructor : constructors) {
					System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
				}
				lines = methods.length + constructors.length;
			} else {
				for (final Method method : methods) {
					if (method.toString().indexOf(args[1]) != -1)
						System.out.println(pattern.matcher(method.toString()).replaceAll(""));
					lines++;
				}
				for (final Constructor constructor : constructors) {
					if (constructor.toString().indexOf(args[1]) != -1)
						System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
					lines++;
				}
			}
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
