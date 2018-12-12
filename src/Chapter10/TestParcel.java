package Chapter10;

public class TestParcel {
	public static void main(final String[] args) {
		final Parcel4 parcel4 = new Parcel4();
		final Contents contents = parcel4.contents();

		final Destination destination = parcel4.destination("Trasmainia ");
		System.out.println(contents);
		System.out.println(destination);
	}
}
