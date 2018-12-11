package Chapter07;

/**
 ********************************************************************** 
 * @Title: Cleanser.java
 * @Description: 继承、基类
 * @author ankie
 * @date 2018年12月6日
 * @version 1.0
 **********************************************************************
 */
public class Cleanser {

	//
	private String string = "Cleanser";

	//
	public void append(final String a) {
		string += a;
	}

	public void dilute() {
		append("dilute()");
	}

	public void apply() {
		append("apply()");
	}

	public void scrub() {
		append("scrub()");
	}

	@Override
	public String toString() {
		return string;
	}

	public static void main(final String[] args) {
		final Cleanser x = new Cleanser();
		x.dilute();
		x.apply();
		x.scrub();
		System.out.println(x);
	}
}
