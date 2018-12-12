package Chapter10;

public class Parcel10 {

	public Destination destination(final String dest, final float price) {
		return new Destination() {
			private int cost;
			{
				cost = Math.round(price);
				if (cost > 100) {
					System.out.println("Over budget!!");
				}
			}
			private final String label = dest;

			@Override
			public String readLabel() {
				return label;
			}
		};
	}

	public static void main(final String[] args) {
		final Parcel10 parcel10 = new Parcel10();
		final Destination destination = parcel10.destination("Tasmainia", 101.396F);
	}
}
