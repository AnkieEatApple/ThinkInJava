package Chapter18;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
	public static void main(final String[] args) {
		try {
			final DataInputStream in = new DataInputStream(new BufferedInputStream(
					new FileInputStream("/Users/ankie/eclipse-workspace/ThinkInJava/src/Chapter18/TestEOF.java")));
			while (in.available() != 0) {
				System.out.println((char) in.readByte());
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
