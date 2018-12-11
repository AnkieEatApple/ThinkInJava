package Chapter08;

/**
 ********************************************************************** 
 * @Title: PolyConstructors.java
 * @Description:
 * @author ankie
 * @date 2018年12月10日
 * @version 1.0
 **********************************************************************
 */
public class PolyConstructors {

	public static void main(final String[] args) {
		new RoundGlyph(5);
	}
}

class Glyph {
	void draw() {
		System.out.println("Glyph.draw()");
	}

	public Glyph() {
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;

	public RoundGlyph(final int r) {
		radius = r;
		System.out.println("RoundGlyph.RoundGlpy().radius = " + radius);
	}

	@Override
	void draw() {
		System.out.println("RoundGlyph.draw().radius = " + radius);
	}
}
