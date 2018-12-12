package Chapter10;

public class GreenhouseControl extends Controller {

	private boolean light = false;

	public class LightOn extends Event {
		public LightOn(final long delayTime) {
			super(delayTime);
		}

		@Override
		public String toString() {
			return "Light is on";
		}

		@Override
		public void action() {
			light = true;
		}
	}

	public class LightOff extends Event {
		public LightOff(final long delayTime) {
			super(delayTime);
		}

		@Override
		public String toString() {
			return "Light is off";
		}

		@Override
		public void action() {
			light = false;
		}
	}

	private boolean water = false;

	public class WaterOn extends Event {
		public WaterOn(final long delayTime) {
			super(delayTime);
		}

		@Override
		public String toString() {
			return "Greenhouser Water is on";
		}

		@Override
		public void action() {
			water = true;
		}
	}

	public class WaterOff extends Event {
		public WaterOff(final long delayTime) {
			super(delayTime);
		}

		@Override
		public String toString() {
			return "Greenhouser Water is off";
		}

		@Override
		public void action() {
			water = false;
		}
	}

	private String thermostat = "Day";

	public class ThermostatNight extends Event {
		public ThermostatNight(final long delayTime) {
			super(delayTime);
		}

		@Override
		public String toString() {
			return "Thermostat on Night setting";
		}

		@Override
		public void action() {
			thermostat = "Night";
		}
	}

	public class ThermostatDay extends Event {
		public ThermostatDay(final long delayTime) {
			super(delayTime);
		}

		@Override
		public String toString() {
			return "Thermostat on Day setting";
		}

		@Override
		public void action() {
			thermostat = "Day";
		}
	}

	public class Bell extends Event {
		public Bell(final long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			addEvent(new Bell(delayTime));

		}

		@Override
		public String toString() {
			return "Bing";
		}
	}

	public class Restart extends Event {
		private final Event[] evenList;

		public Restart(final long delayTime, final Event[] eventList) {
			super(delayTime);
			this.evenList = eventList;
			for (final Event event : eventList) {
				addEvent(event);
			}
		}

		@Override
		public void action() {
			for (final Event event : evenList) {
				event.start();
				addEvent(event);
			}
			start();
			// addEvent(this);
		}

		@Override
		public String toString() {
			return "Restarting System";
		}
	}

	public static class Terminate extends Event {
		public Terminate(final long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			System.exit(0);

		}

		@Override
		public String toString() {
			return "Terminating";
		}
	}

	public static void main(final String[] args) {
		final GreenhouseControl gc = new GreenhouseControl();
		gc.addEvent(gc.new Bell(9000));
		final Event[] eventList = { gc.new ThermostatNight(0), gc.new LightOn(2000), gc.new LightOff(4000),
				gc.new WaterOn(6000), gc.new WaterOff(8000), gc.new ThermostatDay(14000) };

		gc.addEvent(gc.new Restart(2000, eventList));
		if (args.length == 1) {
			gc.addEvent(new GreenhouseControl.Terminate(new Integer(args[0])));
		}
		gc.run();
	}

}
