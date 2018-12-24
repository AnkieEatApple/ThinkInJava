package Chapter15;

public class Generator<T> {

	public Class<T> type;

	public T next() {
		try {
			return type.newInstance();
		} catch (final InstantiationException e) {
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
