package Chapter15;

public class CreateGeneric {

	public static void main(final String[] args) {
		final Creator creator = new Creator();
		creator.f();
	}
}

abstract class GenericWithCreate<T> {
	final T element;

	GenericWithCreate() {
		element = create();
	}

	abstract T create();
}

class X {
}

class Creator extends GenericWithCreate<X> {
	@Override
	X create() {
		return new X();
	}

	void f() {
		System.out.println(element.getClass().getSimpleName());
	}
}
