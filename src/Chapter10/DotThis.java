package Chapter10;

public class DotThis {
	void f() {
		System.out.println("DotThis.f()");
	}

	public class Inner {
		public DotThis outer() {
			return DotThis.this;
		}
	}

	public Inner inner() {
		return new Inner();
	}

	@Override
	public String toString() {
		return "DotThis ";
	}

	public static void main(final String[] args) {
		final DotThis dThis = new DotThis();
		final DotThis.Inner dtInner = dThis.inner();
		// 这里就是调用了上面的内部类，内部类又返回了当前外围类的对象引用
		System.out.println(dtInner.outer());
	}
}
