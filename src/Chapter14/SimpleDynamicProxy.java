package Chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
	public static void consumer(final Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(final String[] args) {
		// 这个就是静态的代理
		final RealObject realObject = new RealObject();
		consumer(realObject);
		// Insert a proxy and call again
		// 动态的代理？？？？？，获取了Interface的类加载器作为参数传了进去？？？？
		final Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
				new Class[] { Interface.class }, new DynamicProxyHandler(realObject));
		consumer(proxy);
		//
		//
	}
}

class DynamicProxyHandler implements InvocationHandler {

	private final Object proxied;

	public DynamicProxyHandler(final Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
		System.out.println("**** proxy : " + proxy.getClass() + ", method : " + method + ", args : " + args);
		if (args != null) {
			for (final Object arg : args) {
				System.out.println(" " + arg);
			}
		}
		return method.invoke(proxied, args);
	}
}
