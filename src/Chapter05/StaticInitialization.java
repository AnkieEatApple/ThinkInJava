package Chapter05;

public class StaticInitialization {

	public static void main(final String[] args) {
		System.out.println("Creating new Cupborad() int main");
		new Cupboard();
		System.out.println("Creating new Cupborad() int main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}

	// (1.1)
	static Table table = new Table();
	// (2.1)
	static Cupboard cupboard = new Cupboard();

}

class Bowl {
	// (1.3) (1.5) (2.3) (2.5)
	public Bowl(final int marker) {
		System.out.println("Bowl(" + marker + ")");
	}

	// (1.8)
	void f1(final int marker) {
		System.out.println("f1(" + marker + ")");
	}
}

class Table {
	// (1.2)
	static Bowl bowl1 = new Bowl(1);

	Table() {
		// (1.6)
		System.out.println("Table()");
		// (1.7)
		bowl1.f1(1);
	}

	void f2(final int marker) {
		System.out.println("f2(" + marker + ")");
	}

	// (1.4)
	static Bowl bowl2 = new Bowl(2);
}

class Cupboard {

	Bowl bowl3 = new Bowl(3);
	// (2.2)
	static Bowl bowl4 = new Bowl(4);

	Cupboard() {
		// (2.6)
		System.out.println("Cupborad()");
		bowl4.f1(2);
	}

	void f3(final int marker) {
		System.out.println("f3(" + marker + ")");
	}

	// (2.4)
	static Bowl bowl5 = new Bowl(5);
}
