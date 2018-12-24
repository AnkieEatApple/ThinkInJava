package Chapter15;

public class FactoryConstraint {
	@SuppressWarnings("unchecked")
	public static void main(final String[] args) {
		new Foo2(new IntegerFactory());
		new Foo2(new Wight.Factory());
	}
}

interface FactoryI<T> {
	T create();
}

class Foo2<T> {
	private final T x;

	@SuppressWarnings("unchecked")
	public <F extends FactoryI> Foo2(final F factory) {
		x = (T) factory.create();
	}
	// ...
}

class IntegerFactory implements FactoryI<Integer> {
	@Override
	public Integer create() {
		System.out.println("IntegerFactory");
		return new Integer(0);
	}
}

class Wight {
	public static class Factory implements FactoryI<Wight> {
		@Override
		public Wight create() {
			return new Wight();
		}
	}
}
