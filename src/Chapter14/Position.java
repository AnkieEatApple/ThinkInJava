package Chapter14;

public class Position {

	private String title;

	private Person person;

	public Position(final String title, Person person) {
		this.title = title;
		this.person = person;
		// 如果对象为空的话，直接调用之前在对象中设计的NULL对象NULLPerson对象的引用
		if (person == null) {
			person = Person.NULL;
		}
	}

	public Position(final String jobTitle) {
		title = jobTitle;
		person = Person.NULL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		if (person == null) {
			person = Person.NULL;
		}
	}

	@Override
	public String toString() {
		return "Position : " + title + " " + person;
	}
}
