package Chapter10;

public class Parcel5 {

	public Destination destination(final String s) {
		class PDestination implements Destination {
			private final String label;

			private PDestination(final String whereTo) {
				label = whereTo;
			}

			@Override
			public String readLabel() {
				return label;
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "PDestination";
			}
		}
		return new PDestination(s);
	}

	public static void main(final String[] args) {
		final Parcel5 parcel5 = new Parcel5();
		final Destination destination = parcel5.destination("Tasmainia");
		System.out.println(destination);
		System.out.println(destination.readLabel());
	}
}
