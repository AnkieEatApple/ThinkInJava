package Chapter15;

public class ClassTypeCapture<T> {

	Class<T> kind;

	public ClassTypeCapture(final Class<T> kind) {
		this.kind = kind;
	}

	public boolean f(final Object arg) {
		return kind.isInstance(arg);
	}

	public static void main(final String[] args) {
		final ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));

		final ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
		System.out.println(ctt2.f(new Building()));
		System.out.println(ctt2.f(new House()));
	}

}

class Building {
}

class House extends Building {
}