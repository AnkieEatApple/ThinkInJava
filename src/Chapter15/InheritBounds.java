package Chapter15;

public class InheritBounds {
	public static void main(final String[] args) {
		final Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
		solid2.color();
		solid2.getY();
//		solid2.weight();
	}
}

class HoldItem<T> {
	T item;

	public HoldItem(final T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}
}

class Colored2<T extends HasColor> extends HoldItem<T> {
	public Colored2(final T item) {
		super(item);
	}

	java.awt.Color color() {
		return item.getColor();
	}
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {
	public ColoredDimension2(final T item) {
		super(item);
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

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {
	public Solid2(final T item) {
		super(item);
	}

	@Override
	int getX() {
		return item.x;
	}

	@Override
	int getY() {
		return item.y;
	}

	@Override
	int getZ() {
		return item.z;
	}
}
