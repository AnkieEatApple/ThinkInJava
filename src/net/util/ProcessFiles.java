package net.util;

import java.io.File;
import java.io.IOException;

import Chapter18.Directory;

/**
 ********************************************************************** 
 * @Title: ProcessFiles.java
 * @Description: 创建一个工具，根据strategy对象来处理这些目录上的文件
 * @author ankie
 * @date 2019年1月1日
 * @version 1.0
 **********************************************************************
 */
public class ProcessFiles {
	// 策略模式的接口
	public interface Strategy {
		// 这个是最后决定传进来的文件应该怎么处理
		void process(File file);
	}

	private final Strategy strategy;

	private final String ext;

	public ProcessFiles(final Strategy strategy, final String ext) {
		this.strategy = strategy;
		this.ext = ext;
	}

	// 这个是具体要深入删选的目录的真正的实现
	public void start(final String[] args) {
		try {
			if (args.length == 0) {
				System.out.println("hello world");
				processDirectoryTree(new File("."));
			} else {
				System.out.println("world hello");
				for (String arg : args) {
					final File fileArg = new File(arg);
					if (fileArg.isDirectory()) {
						processDirectoryTree(fileArg);
					} else {
						// Allow user to leave off extension
						if (!arg.endsWith("." + ext)) {
							arg += "." + ext;
							strategy.process(new File(arg).getCanonicalFile());
						}
					}
				}
			}
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void processDirectoryTree(final File root) throws IOException {
		// 在目录中循环的去寻找这个属于目标文件
		for (final File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			strategy.process(file.getCanonicalFile());
		}
	}

	// Demonstration of how to use it
	public static void main(final String[] args) {
		new ProcessFiles(new Strategy() {

			@Override
			public void process(final File file) {
//				System.out.println("==test==, interface implementation");
				System.out.println(file);
			}
		}, "java").start(args);
	}
}
