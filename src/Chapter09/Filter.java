package Chapter09;

public class Filter {

	public String name() {
		return getClass().getSimpleName();
	}

	public Waveform process(final Waveform input) {
		return input;
	}
}
