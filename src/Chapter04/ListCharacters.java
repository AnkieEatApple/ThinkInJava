package Chapter04;

public class ListCharacters {

	public static void main(final String[] args) {
		for (char c = 0; c < 128; c++) {
			if (Character.isLowerCase(c)) {
				System.out.println("value: " + (int) c + "\t character: " + c);
			}
		}
	}
}
