package Chapter15;

public class BasicBounds {

}

interface HasColor {
	java.awt.Color getColor();
}

class Colored<T extends HasColor> {
	T item;

	public Colored(final T item) {
		this.item = item;
	}
}
