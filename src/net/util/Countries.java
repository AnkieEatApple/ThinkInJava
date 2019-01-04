package net.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Countries {
	public static final String[][] DATA = {

			{ "ALEGERIA", "Algiers" }, { "ANGOLA", "Luanda" }, { "BENNIN", "Porto-Novo" }, { "BOTSWANA", "Gaberone" },
			{ "ALEGERIA", "Algiers" }, { "ANGOLA", "Luanda" }, { "BENNIN", "Porto-Novo" }, { "BOTSWANA", "Gaberone" },
			{ "ALEGERIA", "Algiers" }, { "ANGOLA", "Luanda" }, { "BENNIN", "Porto-Novo" }, { "BOTSWANA", "Gaberone" },
			{ "ALEGERIA", "Algiers" }, { "ANGOLA", "Luanda" }, { "BENNIN", "Porto-Novo" }, { "BOTSWANA", "Gaberone" },
			{ "ALEGERIA", "Algiers" }, { "ANGOLA", "Luanda" }, { "BENNIN", "Porto-Novo" }, { "BOTSWANA", "Gaberone" },
			{ "ALEGERIA", "Algiers" }, { "ANGOLA", "Luanda" }, { "BENNIN", "Porto-Novo" }, { "BOTSWANA", "Gaberone" },
			{ "ALEGERIA", "Algiers" }, { "ANGOLA", "Luanda" }, { "BENNIN", "Porto-Novo" }, { "BOTSWANA", "Gaberone" },
			{ "ALEGERIA", "Algiers" }, { "ANGOLA", "Luanda" }, { "BENNIN", "Porto-Novo" }, { "BOTSWANA", "Gaberone" } };

	private static class FlyweightMap extends AbstractMap<String, String> {
		private static class Entry implements Map.Entry<String, String> {
			int index;

			public Entry(final int index) {
				// System.out.println("Entry(final int index), index : " + index);
				this.index = index;
			}

			@Override
			public boolean equals(final Object o) {
				return DATA[index][0].equals(o);
			}

			@Override
			public String getKey() {
				return DATA[index][0];
			}

			@Override
			public String getValue() {
				return DATA[index][1];
			}

			@Override
			public String setValue(final String value) {
				throw new UnsupportedOperationException();
			}

			@Override
			public int hashCode() {
				return DATA[index][0].hashCode();
			}
		}

		static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
			private int size;

			public EntrySet(final int size) {
				if (size < 0) {
					this.size = 0;
				} else if (size > DATA.length) {
					this.size = DATA.length;
				} else {
					this.size = size;
				}
			}

			private class Iter implements Iterator<Map.Entry<String, String>> {
				private final Entry entry = new Entry(-1);

				@Override
				public boolean hasNext() {
					// System.out.println("hasNext()");
					return entry.index < size - 1;
				}

				@Override
				public Map.Entry<String, String> next() {
					entry.index++;
					// System.out.println("entry.index++;");
					return entry;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			}

			@Override
			public Iterator<java.util.Map.Entry<String, String>> iterator() {
				// System.out.println("new Iter() , size : " + size);
				return new Iter();
			}

			@Override
			public int size() {
				return 0;
			}

		}

		private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

		@Override
		public Set<java.util.Map.Entry<String, String>> entrySet() {
			return entries;
		}
	}

	// create a partial map of 'size' countries;
	static Map<String, String> select(final int size) {
		return new FlyweightMap() {
			@Override
			public Set<Map.Entry<String, String>> entrySet() {
				return new EntrySet(size);
			}
		};
	}

	static Map<String, String> map = new FlyweightMap();

	public static Map<String, String> capitals() {
		return map; // entire map
	}

	public static Map<String, String> capitals(final int size) {
		return select(size);
	}

	static List<String> names = new ArrayList<>(map.keySet());

	// all the names
	public static List<String> names() {
		return names;
	}

	// a partial list
	public static List<String> names(final int size) {
		return new ArrayList<>(select(size).keySet());
	}

	public static void main(final String[] args) {
		System.out.println(capitals(4));
		// System.out.println("entries : " + FlyweightMap.entries);
		// System.out.println("names : " + names);
	}
}
