package Chapter17;

import java.util.ArrayList;

import Chapter15.Generator;

/**
 ********************************************************************** 
 * @Title: CollectionData.java
 * @Description: 适配器模式的一个实例，将Generator适配到Collection的构造器上，也就是将Generator的对象转化为CollectionData的对象
 * @author ankie
 * @date 2018年12月28日
 * @version 1.0
 **********************************************************************
 */
public class CollectionData<T> extends ArrayList<T> {

	private static final long serialVersionUID = 1L;

	public CollectionData(final Generator<T> generator, final int quantiny) {
		for (int i = 0; i < quantiny; i++) {
			add(generator.next());
		}
	}

	// a generic convenoence method
	public static <T> CollectionData<T> list(final Generator<T> generator, final int quantiny) {
		return new CollectionData<T>(generator, quantiny);
	}
}
