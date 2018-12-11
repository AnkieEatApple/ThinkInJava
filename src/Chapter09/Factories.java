package Chapter09;

/**
 ********************************************************************** 
 * @Title: Factories.java
 * @Description: 工厂模式的接口的定义
 * @author ankie
 * @date 2018年12月11日
 * @version 1.0
 **********************************************************************
 */
public class Factories {
	public static void serviceConsumer(final ServiceFactory fact) {
		final Service service = fact.getService();
		service.method1();
		service.method2();
	}

	public static void main(final String[] args) {
		serviceConsumer(new Implementation1Factory());
		//
		serviceConsumer(new Implementation2Factory());
	}
}

interface Service {
	void method1();

	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implementation1Factory implements ServiceFactory {
	@Override
	public Service getService() {
		return new Implementation1();
	}
}

class Implementation1 implements Service {
	public Implementation1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void method1() {
		System.out.println("Implementation1 method1");
	}

	@Override
	public void method2() {
		System.out.println("Implementation1 method2");
	}

}

class Implementation2 implements Service {
	public Implementation2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void method1() {
		System.out.println("Implementation2 method1");
	}

	@Override
	public void method2() {
		System.out.println("Implementation2 method2");
	}

}

class Implementation2Factory implements ServiceFactory {
	@Override
	public Service getService() {
		// TODO Auto-generated method stub
		return new Implementation2();
	}
}
