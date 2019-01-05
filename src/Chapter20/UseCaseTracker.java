package Chapter20;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
	// 传进来的是实现的类
	public static void trackUseCases(final List<Integer> useCases, final Class<?> cl) {
		// 遍历所有的该类中过的方法
		for (final Method method : cl.getDeclaredMethods()) {
			// 获取当前方法中的注解，引用注解为UseCase引用对象
			final UseCase uc = method.getAnnotation(UseCase.class);
			if (uc != null) {
				// 直接输出方法上对应的注解的id和description的值
				System.out.println("Found Use Case: " + uc.id() + " " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for (final int i : useCases) {
			System.out.println("Waring : Missing use case - " + i);
		}
	}

	public static void main(final String[] args) {
		final List<Integer> useCases = new ArrayList<>();
		Collections.addAll(useCases, 47, 48, 49, 50);
		trackUseCases(useCases, PasswordUtils.class);
	}
}
