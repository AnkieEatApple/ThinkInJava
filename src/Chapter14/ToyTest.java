package Chapter14;

public class ToyTest {
	static void printInfo(final Class cc) {
		System.out.println("Class name : " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name: " + cc.getCanonicalName());
		System.out.println("------------------昏割线------------------");
	}

	public static void main(final String[] args) {
		Class c = null;
		try {
			c = Class.forName("Chapter14.FancyToy");
		} catch (final ClassNotFoundException e) {
			System.out.println("can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);

		for (final Class face : c.getInterfaces()) // 获取反射对象中的所有的接口
			printInfo(face);

		final Class up = c.getSuperclass(); // 获取反射对象中的基类
		Object obj = null;

		try {
			obj = up.newInstance(); // 初始化反射对象
		} catch (final InstantiationException e) {
			System.out.println("can't instantiate");
			System.exit(1);
		} catch (final IllegalAccessException e) {
			System.out.println("can't acccess");
			System.exit(1);
		}

		printInfo(obj.getClass());
	}
}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
	// 要是反射的话，必须有无参构造方法
	public Toy() {
	}

	Toy(final int i) {
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	public FancyToy() {
		super(1);
	}
}
