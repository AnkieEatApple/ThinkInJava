package Chapter20;

public class Testable {

	private void execute() {
		System.out.println("Executing...");
	}

	@Test
	void testExecute() {
		execute();
	}
}
