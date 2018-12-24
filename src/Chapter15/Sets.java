package Chapter15;

import java.util.HashSet;
import java.util.Set;

public class Sets {

	public static <T> Set<T> union(final Set<T> a, final Set<T> b) {
		final Set<T> result = new HashSet<>(a);
		// 将两个参数合并到一起
		result.addAll(b);
		return result;
	}

	public static <T> Set<T> intersection(final Set<T> a, final Set<T> b) {
		final Set<T> result = new HashSet<>(a);
		// 将两个参数共有的部分保存
		result.retainAll(b);
		return result;
	}

	public static <T> Set<T> difference(final Set<T> superset, final Set<T> subSet) {
		final Set<T> result = new HashSet<>(superset);
		// 删除了subSet中的含有的元素
		result.removeAll(subSet);
		return result;
	}

	// 返回了Set包含出了交集之外的所有的元素
	public static <T> Set<T> complement(final Set<T> a, final Set<T> b) {
		// union是所有的集合，intersection是共有的部分
		return difference(union(a, b), intersection(a, b));
	}
}
