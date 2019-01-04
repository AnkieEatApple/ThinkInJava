package Chapter18;

import java.io.File;

/**
 ********************************************************************** 
 * @Title: MakeDirectories.java
 * @Description:
 * @author ankie
 * @date 2019年1月1日
 * @version 1.0
 **********************************************************************
 */
public class MakeDirectories {
	private static void usage() {
		System.out.println("" + "Usage:Makedirectories path1 ....\n" + "Creates each path\n"
				+ "Usage:MakeDirectories -d path1 ...\n" + "Deletes each path\n"
				+ "Usage:MakeDirectories -r path1 path2\n" + "Renames from path1 to path2");
		System.exit(1);
	}

	private static void fileData(final File file) {
		System.out.println("Absolute path: " + file.getAbsolutePath() + "\n Can read:" + file.canRead() + "\n getName: "
				+ file.getName() + "\n getPath: " + file.getPath() + "\n getPArent: " + file.getParent() + "\n length: "
				+ file.length() + "\n lastModified: " + file.lastModified());
		if (file.isFile()) {
			System.out.println("It's a file");
		} else if (file.isDirectory()) {
			System.out.println("It's a directory");
		}
	}

	public static void main(final String[] args) {
		if (args.length < 1) {
			usage();
		}
		if (args[0].equals("-r")) {
			if (args.length != 3) {
				usage();
			}
			final File old = new File(args[1]);
			final File rname = new File(args[2]);
			old.renameTo(rname);
			fileData(old);
			fileData(rname);
			return;
		}
		int count = 0;
		boolean del = false;
		if (args[0].equals("-d")) {
			count++;
			del = true;
		}
		count--;
		while (++count < args.length) {
			final File file = new File(args[count]);
			if (file.exists()) {
				System.out.println(file + " exists");
				if (del) {
					System.out.println("delteing..." + file);
					file.delete();
				}
			} else {
				if (!del) {
					file.mkdirs();
					System.out.println("created " + file);
				}
			}
			fileData(file);
		}
	}
}
