package Chapter10;

public class Parcel7 {

	public Contents contents() {
		return new Contents() {
			private final int i = 11;

			@Override
			public int value() {

				return i;
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "Contents";
			}
		};
	}

	public static void main(final String[] args) {
		final Parcel7 parcel7 = new Parcel7();
		final Contents contents = parcel7.contents();

		System.out.println(contents);
		System.out.println(contents.value());

	}
}
