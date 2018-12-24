package Chapter15;

import java.util.ArrayList;
import java.util.Random;

public class Store extends ArrayList<Aisle> {

//	private final ArrayList<CheckoutStand> checkoutStands = new ArrayList<>();

//	private final Office office = new Office();

	private static final long serialVersionUID = 1L;

	public Store(final int nAisle, final int nShelves, final int nProducts) {
		for (int i = 0; i < nAisle; i++) {
			this.add(new Aisle(nShelves, nProducts));
		}
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		for (final Aisle a : this) {
			for (final Shelf shelf : a) {
				for (final Product product : shelf) {
					result.append(product).append("\n");
				}
			}
		}
		return result.toString();
	}

	public static void main(final String[] args) {
		System.out.println(new Store(14, 5, 10));
	}

}

class Product {

	private final int id;

	private final String description;

	private double price;

	public Product(final int IDnumber, final String descr, final double price) {
		id = IDnumber;
		description = descr;
		this.price = price;
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return id + ": " + description + " . price: $" + price;
	}

	public void priceChange(final double change) {
		price += change;
	}

	public static Generator<Product> generator = new Generator<Product>() {
		Random rand = new Random(47);

		@Override
		public Product next() {
			return new Product(rand.nextInt(1000), "\tTest", Math.round(rand.nextDouble() * 1000.0) + 0.99);
		}
	};
}

class Shelf extends ArrayList<Product> {

	private static final long serialVersionUID = 1L;

	public Shelf(final int nProducts) {
		Generators.fill(this, Product.generator, nProducts);
	}

	class CheckoutStand {
	}

	class Office {
	}
}

class Aisle extends ArrayList<Shelf> {

	private static final long serialVersionUID = 1L;

	public Aisle(final int nShelves, final int nProducts) {
		for (int i = 0; i < nShelves; i++) {
			this.add(new Shelf(nProducts));
		}
	}
}
