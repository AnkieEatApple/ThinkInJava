package Chapter10;

public class Parcel11 {
	private static class ParcelContents implements Contents {
		private final int i = 11;

		@Override
		public int value() {
			return i;
		}
	}

	protected static class ParcelDestination implements Destination {
		private final String label;

		private ParcelDestination(final String whereTo) {
			label = whereTo;
		}

		@Override
		public String readLabel() {
			return label;
		}

		//
		public static void f() {
		}

		static int x = 10;

		static class AnoterLevel {
			public static void f() {
			}

			static int x = 10;
		}
	}

	public static Destination destination(final String s) {
		return new ParcelDestination(s);
	}

	public static Contents contents() {
		return new ParcelContents();
	}

	public static void main(final String[] args) {
		final Contents contents = contents();
		final Destination destination = destination("Tasmania");
		System.out.println(destination.readLabel() + " " + Parcel11.ParcelDestination.AnoterLevel.x);
	}
}
