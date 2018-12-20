package Chapter14;

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot {

	private final String name;

	public SnowRemovalRobot(final String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String model() {
		return "SnowBot Series 11";
	}

	@Override
	public List<Operation> operations() {
		return Arrays.asList(new Operation() { // 这里是匿名内部类，覆写了Operation中的方法

			@Override
			public String description() {
				return name + " can shovel snow";
			}

			@Override
			public void command() {
				System.out.println(name + " shoveling snow");
			}
		}, new Operation() {

			@Override
			public String description() {
				return name + " can chip ice";
			}

			@Override
			public void command() {
				System.out.println(name + " can chiping ice");
			}
		}, new Operation() {

			@Override
			public String description() {
				return name + " can clear the roof";
			}

			@Override
			public void command() {
				System.out.println(name + " clearing roof");
			}
		});
	}

//	public static void main(final String[] args) {
//		Robot.Test.test(new SnowRemovalRobot("Slusher"));
//		// 这个Slusher对象是创建了SnowRemovalRobot对象，对这个对象命名，同时对这个对象给予了一个 List<Operation>
//		// List<Operation> 里面有三个元素，每个元素里面都实现了不同的描述和命令
//	}
}
