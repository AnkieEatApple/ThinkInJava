package Chapter07;

/**
 ********************************************************************** 
 * @Title: CADSystem.java
 * @Description: 确保正确清理
 * @author ankie
 * @date 2018年12月6日
 * @version 1.0
 **********************************************************************
 */
public class CADSystem extends Shape {

	//
	private Circle circle;
	private Triangle triangle;
	private final Line[] lines = new Line[3];

	CADSystem(final int i) {
		super(i + 1);
		for (int j = 0; j < lines.length; j++) {
			lines[j] = new Line(j, j * j);
		}

	}

}

class Shape {
	Shape(final int i) {
		System.out.println("Shape constructor.");
	}

	void dispose() {
		System.out.println("Shpae dispose.");
	}
}

class Circle extends Shape {
	Circle(final int i) {
		super(i);
		System.out.println("Drawing Circle.");
	}

	@Override
	void dispose() {
		System.out.println("Erasing Circle.");
		super.dispose();
	}
}

class Triangle extends Shape {

	Triangle(final int i) {
		super(i);
		System.out.println("Drawing Triangle.");
	}

	@Override
	void dispose() {
		System.out.println("Erasing Triangle.");
		super.dispose();
	}
}

class Line extends Shape {

	private final int start;
	private final int end;

	Line(final int start, final int end) {
		super(start);
		this.start = start;
		this.end = end;
		System.out.println("Line Triangle.");
	}

	@Override
	void dispose() {
		System.out.println("Line Triangle.");
		super.dispose();
	}
}
