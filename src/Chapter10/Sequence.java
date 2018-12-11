package Chapter10;

/**
 ********************************************************************** 
 * @Title: Sequence.java
 * @Description: 就是在内部类中实现外部接口
 * @author ankie
 * @date 2018年12月11日
 * @version 1.0
 **********************************************************************
 */
public class Sequence {

	private final Object[] items;
	private int next = 0;

	public Sequence(final int size) {
		items = new Object[size];
	}

	public void add(final Object x) {
		if (next < items.length) {
			items[next++] = x;
		}
	}

	// 这里实现的接口就是其他文件中的
	private class SequenceSelector implements Selector {
		private int i = 0;

		@Override
		public boolean end() {
			return i == items.length;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if (i < items.length) {
				i++;
			}
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}

	public static void main(final String[] args) {
		final Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		final Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.println(selector.current());
			selector.next();
		}
	}
}
