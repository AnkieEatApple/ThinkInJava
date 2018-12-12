package Chapter10;

import java.util.ArrayList;
import java.util.List;

public class Controller {

	private final List<Event> eventList = new ArrayList<>();

	public void addEvent(final Event c) {
		eventList.add(c);
	}

	public void run() {
		while (eventList.size() > 0) {
			for (final Event event : new ArrayList<>(eventList)) {
				if (event.ready()) {
					System.out.println("ToString : " + event);
					event.action();
					eventList.remove(event);
				}
			}
		}
	}
}
