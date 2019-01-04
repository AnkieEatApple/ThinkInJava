package Chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {

	static String file = "/Users/ankie/eclipse-workspace/ThinkInJava/src/Chapter18/BasicFileOutput.java";

	public static void main(final String[] args) throws IOException {
		// 这里是将文件写入放入
		final BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(file)));
		// 设置了一个输出，输出的对象就是FileWrite，就是源文件
		final PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		// 设置了开始的行数
		int lineCount = 1;
		// buffer
		String s;
		while ((s = in.readLine()) != null) {
			// 这个是装饰工作
			out.println(lineCount++ + ": " + s);
		}
		// 关闭out
		out.close();
		// 这个是将写入完成的程序输出出来
		System.out.println(BufferedInputFile.read(file));
	}
}
