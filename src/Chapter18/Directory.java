package Chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import net.util.PPrint;

/**
 ********************************************************************** 
 * @Title: Directory.java
 * @Description: 打印当前目录下的所有文件带路径
 * @author ankie
 * @date 2018年12月30日
 * @version 1.0
 **********************************************************************
 */
public class Directory {
	// local方法使用被成为listFile()的File.list()的变体来产生File数组
	public static File[] local(final File dir, final String regex) {
		return dir.listFiles(new FilenameFilter() {
			private final Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(final File dir, final String name) {
				return pattern.matcher(name).matches();
			}
		});
	}

	// 重写上面的方法，将路径转化为File对对象
	public static File[] local(final String path, final String regex) {
		return local(new File(path), regex);
	}

	// a two-tuple for returning a pair of Objects;
	public static class TreeInfo implements Iterable<File> {
		// 这个是文件名的集合
		public List<File> files = new ArrayList<>();
		// 这个是路径的集合
		public List<File> dirs = new ArrayList<>();

		// the default iterator element is the file list;
		@Override
		public Iterator<File> iterator() {
			// 循环迭代返回文件的集合？？？？
			return files.iterator();
		}

		void addAll(final TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		@Override
		public String toString() {
			return "dirs" + PPrint.pformat(dirs)
					+ "\n--------------------------------------------------------------------------------\n" + "files: "
					+ PPrint.pformat(files);
		}
	}

	public static TreeInfo walk(final String start, final String regex) {
		return recurseDirs(new File(start), regex);
	}

	public static TreeInfo walk(final File start, final String regex) {
		return recurseDirs(start, regex);
	}

	public static TreeInfo walk(final String start) {
		return recurseDirs(new File(start), ".");
	}

	public static TreeInfo walk(final File start) {
		return recurseDirs(start, ".");
	}

	// 最后都调到这里，这里是根据获取到的路径和文件对象，将这个包装成TreeInfo的对象
	static TreeInfo recurseDirs(final File startDir, final String regex) {
		// 首先是创建了一个TreeInfo的对象
		final TreeInfo result = new TreeInfo();
		// 获取传进来的这个File对象的listFiles，然后遍历循环
		for (final File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				// 如果这个是路径的话，就添加到路径的集合中
				result.dirs.add(item);
				// 这个就是向下查询当前的路径下，是都还有对应的路径和文件名
				result.addAll(recurseDirs(item, regex));
			} else {
				// 如果这个是文件名的话，就添加到文件名中
				// regular file
				// 真正筛选的是这个matches的方法
				if (item.getName().matches(regex))
					result.files.add(item);
			}
		}
		return result;
	}

	public static void main(final String[] args) {
		if (args.length == 0) {
			System.out.println(walk("."));
		} else {
			for (final String arg : args)
				System.out.println(walk(arg));
		}
	}
}
