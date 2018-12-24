package Chapter15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Customer {

	private static long counter = 1;

	private final long id = counter++;

	private Customer() {
	}

	@Override
	public String toString() {
		return "Customer " + id;
	}

	public static Generator<Customer> generator() {
		return new Generator<Customer>() {
			@Override
			public Customer next() {
				return new Customer();
			}
		};
	}

	public static void main(final String[] args) {
		final Random random = new Random(47);
		final Queue<Customer> line = new LinkedList<>();
		Generators.fill(line, Customer.generator(), 15);
		final List<Teller> tellers = new ArrayList<>();
		Generators.fill(tellers, Teller.generator, 4);
		for (final Customer customer : line) {
			BankTeller.serve(tellers.get(random.nextInt(tellers.size())), customer);
		}
	}
}

class Teller {
	private static long counter = 1;

	private final long id = counter++;

	private Teller() {
	}

	public static Generator<Teller> generator = new Generator<Teller>() {
		@Override
		public Teller next() {
			return new Teller();
		}
	};

	@Override
	public String toString() {
		return "teller " + id;
	}
}

class BankTeller {

	static void serve(final Teller teller, final Customer customer) {
		System.out.println(teller + " serves " + customer);
	}

}