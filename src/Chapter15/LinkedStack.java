package Chapter15;

public class LinkedStack<T> {

	private static class Node<U> {
		U item;
		Node<U> next;

		public Node() {
			item = null;
			next = null;
		}

		public Node(final U item, final Node<U> next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	private Node<T> top = new Node<T>();

	public void push(final T item) {
		top = new Node<T>(item, top);
		System.out.println(top);
	}

	public T pop() {
		final T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}

	public static void main(final String[] args) {
		final LinkedStack<String> lss = new LinkedStack<>();
		for (final String string : "Phasers on stun!".split(" "))
			lss.push(string);
		String s;
		while ((s = lss.pop()) != null)
			System.out.println(s);
	}

}
