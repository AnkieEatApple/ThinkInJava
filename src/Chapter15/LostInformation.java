package Chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LostInformation {

	public static void main(final String[] args) {
		final List<Frob> list = new ArrayList<>();
		final Map<Frob, Fnorkle> map = new HashMap<>();
		final Quark<Fnorkle> quark = new Quark<>();
		final Particle<Long, Double> particle = new Particle<>();

		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));
	}
}

class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSITION, MOMENTUM> {
}