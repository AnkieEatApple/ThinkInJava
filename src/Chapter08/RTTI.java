package Chapter08;

public class RTTI {
	public static void main(final String[] args) {
		final Useful[] x = { new Useful(), new MoreUseful() };
		x[0].f();
		x[1].g();
		((MoreUseful) x[1]).u();
		((MoreUseful) x[0]).u();
	}
}

class Useful {
	public void f() {
	}

	public void g() {
	}
}

class MoreUseful extends Useful {
	@Override
	public void f() {
	}

	@Override
	public void g() {
	}

	public void u() {
		System.out.println("llll");
	}

	public void v() {
	}

	public void w() {
	}
}
