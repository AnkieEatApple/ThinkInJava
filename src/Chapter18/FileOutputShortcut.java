package Chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {

	static String file = "/Users/ankie/eclipse-workspace/ThinkInJava/src/Chapter18/BasicFileOutput.java";

	public static void main(final String[] args) throws IOException {

		final BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(file)));
		// here is the shortcut
		final PrintWriter out = new PrintWriter(file);
		
		int lineCount = 1;
		String s;
		
		while ((s = in.readLine()) != null ) {
			out.println(lineCount++ + ": "  + s);
		}
		out.close();
		//
		System.out.println(BufferedInputFile.read(file));
	}
}
