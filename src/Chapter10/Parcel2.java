package Chapter10;

/**
 ********************************************************************** 
 * @Title: Parcel2.java
 * @Description: 类似与工厂模式，然后通过外部类创建某个内部类的对象
 * @author ankie
 * @date 2018年12月11日
 * @version 1.0
 **********************************************************************
 */
public class Parcel2 {

	class Contents {
		private final int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {
		private final String label;

		Destination(final String whereTo) {
			label = whereTo;
		}

		String readLabel() {
			return label;
		}
	}

	public Destination to(final String s) {
		return new Destination(s);
	}

	public Contents contents() {
		return new Contents();
	}

	public void ship(final String dest) {
		final Contents contents = contents();
		final Destination destination = to(dest);
		System.out.println(destination.readLabel());
	}

	public static void main(final String[] args) {

		final Parcel2 parcel2 = new Parcel2();
		// 这种是通过适配器模式同时创建了两种内部类的对象
		parcel2.ship("Tasmaina");
		final Parcel2 qParcel2 = new Parcel2();
		// 分别通过外部方法创建了该类中的内部类的对象
		final Parcel2.Contents contents = qParcel2.contents();
		final Parcel2.Destination destination = qParcel2.to("Borneo");
	}
}
