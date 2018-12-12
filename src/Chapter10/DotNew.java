package Chapter10;

public class DotNew {
	class Inner {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Inner";
		}
	}

	public static void main(final String[] args) {
		final DotNew dotNew = new DotNew();
		final DotNew.Inner dInner = dotNew.new Inner();
		System.out.println(dInner);
	}
}
