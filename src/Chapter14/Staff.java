package Chapter14;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {

	private static final long serialVersionUID = 1L;

	public void add(final String title, final Person person) {
		add(new Position(title, person));
	}

	public void add(final String... titles) {
		for (final String title : titles) {
			add(new Position(title));
		}
	}

	public Staff(final String... titles) {
		add(titles);
	}

	public boolean positionAvailable(final String title) {
		for (final Position position : this) {
			if (position.getTitle().equals(title) && position.getPerson() == Person.NULL) {
				return true;
			}
		}
		return false;
	}

	public void fillPosition(final String title, final Person hire) {
		for (final Position position : this) {
			if (position.getTitle().equals(title) && position.getPerson() == Person.NULL) {
				position.setPerson(hire);
				return;
			}
		}
		throw new RuntimeException("Position " + title + " not available");
	}

	public static void main(final String[] args) {
		final Staff staff = new Staff("President", "CTO", "Marketing Manager", "Product Manager", "Project Lead",
				"Software Engineer", "Software Engineer", "Software Engineer", "Test Engineer", "Technical Writer");

		staff.fillPosition("President", new Person("Me", "Last", "The Top, Lonely At"));

		staff.fillPosition("Project Lead", new Person("Janet", "Planner", "The Burbs"));

		if (staff.positionAvailable("Software Engineer")) {
			staff.fillPosition("Software Engineer", new Person("Bob", "Coder", "Bright Light City"));
		}
//		System.out.println(staff);
		for (final Position position : staff) {
			System.out.println(position);
		}
	}
}
