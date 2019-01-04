package Chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 ********************************************************************** 
 * @Title: DirList2.java
 * @Description: 这个是创建的内部类的实现的方式
 * @author ankie
 * @date 2018年12月30日
 * @version 1.0
 **********************************************************************
 */
public class DirList2 {
	public static FilenameFilter filter(final String regex) {
		// Creation of anonymous inner class
		return new FilenameFilter() {
			private final Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(final File dir, final String name) {
				return pattern.matcher(name).matches();
			}
		};
	}

	public static void main(final String[] args) {
		final File path = new File(".");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(filter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (final String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
