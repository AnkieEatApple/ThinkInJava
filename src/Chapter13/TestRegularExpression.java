package Chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {

	public static void ll(final String[] args) {
		if (args.length < 2) {
			System.out.println("Usgaw:\njava TestRegularExpression " + "characterSequence regularExpression+");
			System.exit(0);
		}

		System.out.println("Input: \"" + args[0] + "\"");
		for (final String string : args) {
			System.out.println("Regular expression: \"" + args + "\"");
			final Pattern pattern = Pattern.compile(string);
			final Matcher matcher = pattern.matcher(args[0]);
			while (matcher.find()) {
				System.out.println("Match \"" + matcher.group() + "\" at positions " + matcher.start() + "-"
						+ (matcher.end() - 1));
			}
		}
	}

	public static void main(final String[] args) {

		final String string = "abcabcabcdefabc";
		final char[] c = string.toCharArray();
//		ll(c);
	}

}
