package Chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 ********************************************************************** 
 * @Title: NullRobot.java
 * @Description:
 * @author ankie
 * @date 2018年12月20日
 * @version 1.0
 **********************************************************************
 */
public class NullRobot {
	public static Robot newNullRobot(final Class<? extends Robot> type) {
		return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), new Class[] { Null.class, Robot.class },
				new NullRobotProxyHandler(type));
	}

	public static void main(final String[] args) {
		final Robot[] robots = { new SnowRemovalRobot("SnowBee"), newNullRobot(SnowRemovalRobot.class) };
		for (final Robot robot : robots) {
			Robot.Test.test(robot);
			System.out.println("----------------------");
		}
	}
}

class NullRobotProxyHandler implements InvocationHandler {

	private final String nullName;

	private final Robot proxied = new NRobot();

	public NullRobotProxyHandler(final Class<? extends Robot> type) {
		nullName = type.getSimpleName() + " NullRobot";
	}

	private class NRobot implements Null, Robot {
		@Override
		public String name() {
			return nullName;
		}

		@Override
		public String model() {
			return nullName;
		}

		@Override
		public List<Operation> operations() {
			return Collections.emptyList();
		}
	}

	@Override
	public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
}