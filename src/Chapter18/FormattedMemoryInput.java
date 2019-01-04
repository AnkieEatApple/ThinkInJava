package Chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {

	public static void main(final String[] args) throws IOException {

		try {
			final DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(BufferedInputFile
					.read("/Users/ankie/eclipse-workspace/ThinkInJava/src/Chapter18/FormattedMemoryInput.java")
					.getBytes()));
			while (true)
				System.out.println((char) inputStream.readByte());
		} catch (final EOFException e) {
			System.err.println("End of stream");
		}
	}
}
