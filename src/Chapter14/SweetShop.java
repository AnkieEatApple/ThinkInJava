package Chapter14;

public class SweetShop {
	public static void main(final String[] args) {
		System.out.println("inside main");

		new Candy();

		System.out.println("After creating candy");

		try {
			Class.forName("Chapter14.Gum");
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("after Class.forName(\"Gum\")");

		new Cookie();

		System.out.println("after creating cookie");
	}
}

class Candy {
	static {
		System.out.println("Loading Candy!");
	}
}

class Gum {
	static {
		System.out.println("Loading Gum!");
	}
}

class Cookie {
	static {
		System.out.println("loading Cookie");
	}
}
