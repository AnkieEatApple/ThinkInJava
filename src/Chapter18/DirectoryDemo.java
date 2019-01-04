package Chapter18;

import java.io.File;

public class DirectoryDemo {

	public static void main(final String[] args) {
		// all directories
//		PPrint.pprint(Directory.walk(".").dirs);

		// all files beginning with 'T'
		for (final File file : Directory.local(".", "T.*")) {
			System.out.println(file);
		}
		System.out.println("-------------------------");
		// all java files beginning with "T"
		for (final File file : Directory.walk(".", "T.*\\.java")) {
			System.out.println(file);
		}
		System.out.println("--------------------------");
		// class files containing "Z" or "z"
		for (final File file : Directory.walk(".", ".*[Zz].*\\.class")) {
			System.out.println(file);
		}
	}
}
