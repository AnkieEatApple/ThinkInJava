package Chapter10;

public class Callbacks {
	public static void main(final String[] args) {
		final Callee1 callee1 = new Callee1();
		final Callee2 callee2 = new Callee2();
		MyIncrement.f(callee2);
		final Caller caller1 = new Caller(callee1);
		final Caller caller2 = new Caller(callee2.getCallbackRefrence());
		caller1.go();
		caller1.go();
		caller2.go();
	}
}

interface Incrementable {
	void increment();
}

// 简单的实现接口
class Callee1 implements Incrementable {
	private int i = 0;

	@Override
	public void increment() {
		i++;
		System.out.println(i);
	}
}

class MyIncrement {
	public void incrememt() {
		System.out.println("Other operation");
	}

	static void f(final MyIncrement myIncrement) {
		myIncrement.incrememt();
	}
}

class Callee2 extends MyIncrement {
	private int i = 0;

	public void increment() {
		super.incrememt();
		i++;
		System.out.println(i);
	}

	private class Closure implements Incrementable {
		@Override
		public void increment() {
			Callee2.this.incrememt();
		}
	}

	Incrementable getCallbackRefrence() {
		return new Closure();
	}
}

class Caller {
	private final Incrementable callbackRefrence;

	public Caller(final Incrementable cbn) {
		callbackRefrence = cbn;
	}

	void go() {
		callbackRefrence.increment();
	}
}
