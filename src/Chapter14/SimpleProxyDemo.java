package Chapter14;

public class SimpleProxyDemo {
	public static void consumer(final Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(final String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}

interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

class RealObject implements Interface {

	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}

	@Override
	public void somethingElse(final String arg) {
		System.out.println("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private final Interface proxied;

	public SimpleProxy(final Interface proxied) {
		this.proxied = proxied;
	}

	@Override
	public void doSomething() {
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(final String arg) {
		System.out.println("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
	}
}
