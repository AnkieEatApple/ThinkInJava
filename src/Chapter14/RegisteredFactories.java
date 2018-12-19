package Chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegisteredFactories {
	public static void main(final String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Part.createRandom());
		}
	}
}

class Part {
	@Override
	public String toString() {

		return getClass().getName();
	}

	static List<Factory<? extends Part>> partFactories = new ArrayList<>();
	static {
		//
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
	}
	private static Random random = new Random(47);

	public static Part createRandom() {
		final int n = random.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part {
}

class FuelFilter extends Filter {
	//
	public static class Factory implements Chapter14.Factory<FuelFilter> {
		@Override
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}

class AirFilter extends Filter {
	//
	public static class Factory implements Chapter14.Factory<AirFilter> {
		@Override
		public AirFilter create() {
			return new AirFilter();
		}
	}
}

class CabinFilter extends Filter {
	//
	public static class Factory implements Chapter14.Factory<CabinFilter> {
		@Override
		public CabinFilter create() {
			return new CabinFilter();
		}
	}
}

class OilFilter extends Filter {
	//
	public static class Factory implements Chapter14.Factory<OilFilter> {
		@Override
		public OilFilter create() {
			return new OilFilter();
		}
	}
}

class Belt extends Part {
}

class FanBelt extends Belt {
	//
	public static class Factory implements Chapter14.Factory<FanBelt> {
		@Override
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt {
	//
	public static class Factory implements Chapter14.Factory<GeneratorBelt> {
		@Override
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt {
	//
	public static class Factory implements Chapter14.Factory<PowerSteeringBelt> {
		@Override
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}