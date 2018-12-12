package Chapter10;

public class Parcel4 {

	private class PContents implements Contents {
		private final int i = 11;

		@Override
		public int value() {
			return i;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "PContents";
		}
	}

	protected class PDestination implements Destination {

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

	public Destination destination(final String s) {
		return new PDestination(s);
	}

	public Contents contents() {
		return new PContents();
	}
}
