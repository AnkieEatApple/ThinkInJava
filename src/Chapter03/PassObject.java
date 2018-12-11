package Chapter03;

class Letter {
	char c;
}

public class PassObject {

	static void f(final Letter l) {
		l.c = 'z';
	}

	public static void main(final String[] args) {

		final Letter x = new Letter();
		x.c = 'a';
		System.out.println("1. x.c : " + x.c);
		// 这里的引用对象还是 ‘a’

		f(x);
		System.out.println("1. x.c : " + x.c);
		// 实际上改变的是引用对象，虽然l.c是局部变量，但是将l.c的引用改为 ‘z’了
	}
}
