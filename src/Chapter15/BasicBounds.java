package Chapter15;

public class BasicBounds {
	public static void main(final String[] args) {
		final Solid<Bounded> solid = new Solid<>(new Bounded());
		solid.color();
		solid.getY();
		solid.weight();
	}
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

class Dimension {
	public int x, y, z;
}

class ColoredDimension<T extends Dimension & HasColor> {
	T item;

	public ColoredDimension(final T item) {
		this.item = item;
	}

	T getItem() {
		return this.item;
	}

	java.awt.Color color() {
		return item.getColor();
	}

	int getX() {
		return item.x;
	}

	int getY() {
		return item.y;
	}

	int getZ() {
		return item.z;
	}
}

interface Weight {
	int weight();
}

class Solid<T extends Dimension & HasColor & Weight> {
	T item;

	public Solid(final T item) {
		this.item = item;
	}

	T getItem() {
		return this.item;
	}

	java.awt.Color color() {
		return item.getColor();
	}

	int getX() {
		return item.x;
	}

	int getY() {
		return item.y;
	}

	int getZ() {
		return item.z;
	}

	int weight() {
		return item.weight();
	}
}

class Bounded extends Dimension implements HasColor, Weight {
	@Override
	public java.awt.Color getColor() {
		return null;
	}

	@Override
	public int weight() {
		return 0;
	}
}