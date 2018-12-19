package Chapter14;

public class FamilyVsExactType {

	static void test(final Object x) {
		System.out.println("Testing x of type " + x.getClass());
		System.out.println("x instanceof Base " + (x instanceof Base));
		System.out.println("x instanceof Derived " + (x instanceof Derived));
		System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
		System.out.println("----");
		System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));
		System.out.println("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
		System.out.println("x.getClass().equals(Base.class) " + (x.getClass().equals(Base.class)));
		System.out.println("x.getClass().equals(Derived.class) " + (x.getClass().equals(Derived.class)));
		System.out.println("====");
	}

	public static void main(final String[] args) {
		test(new Base());
		test(new Derived());
	}
}

class Base {
}

class Derived extends Base {
}
