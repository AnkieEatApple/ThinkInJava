package Chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 ********************************************************************** 
 * @Title: DirList3.java
 * @Description: 这个使用的是匿名的内部类
 * @author ankie
 * @date 2018年12月30日
 * @version 1.0
 **********************************************************************
 */
public class DirList3 {

	public static void main(final String[] args) {
		final File path = new File(".");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new FilenameFilter() {
				private final Pattern pattern = Pattern.compile(args[0]);

				@Override
				public boolean accept(final File dir, final String name) {
					return pattern.matcher(name).matches();
				}
			});
		}
//		for (final String dirItem : list) {
//			System.out.println(dirItem);
//		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (final String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
