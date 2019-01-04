package Chapter17;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import net.util.Countries;

public class Lists {

	private static boolean b;
	private static String s;
	private static int i;
	private static Iterator<String> it;
	private static ListIterator<String> lit;

	public static void basicTest(final List<String> a) {
		a.add(1, "x");
		a.add("x");
		// add a collection
		a.addAll(Countries.names(25));
		// add a collection starting at location 3
		a.addAll(3, Countries.names(25));
		b = a.contains("1");
		// is the entire collection in there
		b = a.containsAll(Countries.names(25));
		// Lists allow random access, which is cheap
		// for arrayList, expensive for Linkedlist
		s = a.get(1);
		i = a.indexOf("1");
		b = a.isEmpty();
		it = a.iterator();
		lit = a.listIterator();
		lit = a.listIterator(3); // start at loc 3
		i = a.lastIndexOf("1"); // last match
		a.remove(1);
		a.remove("3");
		a.set(1, "y");
		// keep everything that's in the argument
		a.retainAll(Countries.names(25));
		a.removeAll(Countries.names(25));
		i = a.size();
		a.clear();
	}

	public static void iterMotion(final List<String> a) {
		final ListIterator<String> iterator = a.listIterator();
		b = iterator.hasNext();
		b = iterator.hasPrevious();
		s = iterator.next();
		i = iterator.nextIndex();
		s = iterator.previous();
		i = iterator.previousIndex();
	}

	public static void iterManipulation(final List<String> a) {
		final ListIterator<String> iterator = a.listIterator();
		iterator.add("47");
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.set("47");
	}

	public static void testVisual(final List<String> a) {
		System.out.println(a);
		final List<String> b = Countries.names(25);
		System.out.println("b: " + b);
		a.addAll(b);
		System.out.println("a.size: " + a.size());
		a.addAll(b);
		System.out.println("a.size: " + a.size());
		System.out.println(a);
		ListIterator<String> x = a.listIterator(a.size() / 2);
		x.add("one");
		System.out.println("a.size: " + a.size());
		System.out.println(a);
		System.out.println(x.next());
		x.remove();
		System.out.println(x.next());
		x.remove();
		System.out.println(x.next());
		x.set("47");
		System.out.println("a.size: " + a.size());
		System.out.println(a);
		//
		x = a.listIterator(a.size());
		while (x.hasPrevious()) {
			System.out.print(x.previous() + " ");
		}
		System.out.println();
		System.out.println("testVisual finish");
	}

	public static void main(final String[] args) {
		testVisual(new LinkedList<>(Countries.names(25)));
	}
}
