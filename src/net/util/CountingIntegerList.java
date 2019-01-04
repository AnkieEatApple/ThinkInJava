package net.util;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {

	private final int size;

	public CountingIntegerList(final int size) {
		this.size = size < 0 ? 0 : size;
	}

	@Override
	public Integer get(final int index) {
		return Integer.valueOf(index);
	}

	@Override
	public int size() {
		return size;
	}

	public static void main(final String[] args) {
		System.out.println(new CountingIntegerList(30));
	}
}
