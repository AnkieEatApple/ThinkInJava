package Chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 ********************************************************************** 
 * @Title: SelectingMethods.java
 * @Description:
 * @author ankie
 * @date 2018年12月20日
 * @version 1.0
 **********************************************************************
 */
public class SelectingMethods {
	public static void main(final String[] args) {
		final Implementation implementation = new Implementation();
		final InvocationHandler handler = new MethodSelector(implementation);
		final Class<?> cls = implementation.getClass();
		/**
		 * 
		 */
		final SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(),
				handler);
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");
		proxy.boring3();
	}
}

/**
 ********************************************************************** 
 * @Title: SelectingMethods.java
 * @Description:
 * @author ankie
 * @date 2018年12月20日
 * @version 1.0
 **********************************************************************
 */
class MethodSelector implements InvocationHandler {

	private final Object proxied;

	public MethodSelector(final Object proxied) {
		this.proxied = proxied;
	}

	/**
	 * proxy: 被代理的对象 method：被代理的方法 args：方法参数
	 */
	@Override
	public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
		if (method.getName().equals("interesting")) {
			System.out.println("Proxy detected the interesting method");
		}
		return method.invoke(proxied, args);
	}
}

/**
 ********************************************************************** 
 * @Title: SelectingMethods.java
 * @Description:
 * @author ankie
 * @date 2018年12月20日
 * @version 1.0
 **********************************************************************
 */
interface SomeMethods {
	void boring1();

	void boring2();

	void interesting(String arg);

	void boring3();
}

/**
 ********************************************************************** 
 * @Title: SelectingMethods.java
 * @Description:
 * @author ankie
 * @date 2018年12月20日
 * @version 1.0
 **********************************************************************
 */
class Implementation implements SomeMethods {

	@Override
	public void boring1() {
		System.out.println("boring1");
	}

	@Override
	public void boring2() {
		System.out.println("boring2");
	}

	@Override
	public void interesting(final String arg) {
		System.out.println("interesting " + arg);
	}

	@Override
	public void boring3() {
		System.out.println("boring3");
	}
}