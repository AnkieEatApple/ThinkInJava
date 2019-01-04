package Chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 ********************************************************************** 
 * @Title: DirList.java
 * @Description: 普通的实现的查找指定的文件夹下文件的名称的方式，通过实现FilenameFilter的accept方法
 * @author ankie
 * @date 2018年12月30日
 * @version 1.0
 **********************************************************************
 */
public class DirList {
	public static void main(final String[] args) {
		final File path = new File(".");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (final String dirItem : list) {
			System.out.println(dirItem);
		}
	}

}

class DirFilter implements FilenameFilter {

	private final Pattern pattern;

	public DirFilter(final String regex) {
		this.pattern = Pattern.compile(regex);
	}

	@Override
	public boolean accept(final File dir, final String name) {
		return pattern.matcher(name).matches();
	}

}
