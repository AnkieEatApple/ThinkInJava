package Chapter18;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

	public static void main(final String[] args) throws IOException {
		final StringReader in = new StringReader(
				BufferedInputFile.read("/Users/ankie/eclipse-workspace/ThinkInJava/src/Chapter18/MemoryInput.java"));
		int c;
		while ((c = in.read()) != -1) {
			System.out.println((char) c);
		}
	}
}
