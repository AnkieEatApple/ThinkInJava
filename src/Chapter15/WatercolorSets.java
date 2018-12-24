package Chapter15;

import java.util.EnumSet;
import java.util.Set;

public class WatercolorSets {

	public static void main(final String[] args) {

		final Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUE);

		System.out.println(set1);
	}
}
