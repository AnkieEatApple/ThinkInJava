package Chapter15;

public class Holder1 {
	private final Automobile a;

	public Holder1(final Automobile a) {
		this.a = a;
	}

	Automobile get() {
		return this.a;
	}
}

class Automobile {

}