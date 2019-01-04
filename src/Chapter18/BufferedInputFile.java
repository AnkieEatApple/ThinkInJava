package Chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

	// throw exceptions to console
	public static String read(final String filename) throws IOException {
		// reading input by lines;
		final BufferedReader in = new BufferedReader(new FileReader(filename));
		String string;
		final StringBuilder sb = new StringBuilder();
		while ((string = in.readLine()) != null) {
			sb.append(string + "\n");
		}
		in.close();
		return sb.toString();
	}

	public static void main(final String[] args) {
//		final BufferedInputFile bufferedInputFile = new BufferedInputFile();
//		final File file = new File(bufferedInputFile.getClass().getResource("/").getPath());
//		System.out.println(file);
//
////		final String pathName = file.toString() + "/Chapter18/BufferedInputFile.java";
////		System.out.println(pathName);
//
//		final File file2 = new File("");
//		try {
//			System.out.println(file2.getCanonicalPath());
//		} catch (final Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		final Properties properties = System.getProperties();
//		System.out.println(properties.getProperty("BufferedInputFile.java"));
		try {
			System.out.println(read("/Users/ankie/eclipse-workspace/ThinkInJava/src/Chapter18/BufferedInputFile.java"));
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}
}
