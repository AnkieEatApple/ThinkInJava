package Chapter15;

/**
 ********************************************************************** 
 * @Title: Manipulator.java
 * @Description: 定义边界
 * @author ankie
 * @date 2018年12月24日
 * @version 1.0
 **********************************************************************
 */
public class Manipulator<T extends HasF> { // 这个extends就是边界
	private final T obj;

	public Manipulator(final T x) {
		obj = x;
	}

	void manipulate() {
		obj.f();
	}

	public static void main(final String[] args) {
		final HasF hasF = new HasF();
		final Manipulator<HasF> manipulator = new Manipulator<HasF>(hasF);
		manipulator.manipulate();
	}
}

class HasF {
	public void f() {
		System.out.println("HasF.f()");
	}
}
