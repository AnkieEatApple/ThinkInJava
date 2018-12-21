package Chapter15;

public class Holder2 {

	private Object a;

	public Holder2(final Object a) {
		this.a = a;
	}

	public void set(final Object a) {
		this.a = a;
	}

	public Object get() {
		return a;
	}

	public static void main(final String[] args) {
		final Holder2 h2 = new Holder2(new Automobile());
		final Automobile automobile = (Automobile) h2.get();
		h2.set("Not an Automobile");

		final String string = (String) h2.get();
		h2.set(1);
		final Integer xInteger = (Integer) h2.get();

		System.out.println(automobile + string + xInteger);
	}
}
