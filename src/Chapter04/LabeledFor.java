package Chapter04;

/**
 ********************************************************************** 
 * @Title: LabeledFor.java
 * @Description: 跳出外层循环的标签用法，好NB
 * @author ankie
 * @date 2018年11月30日
 * @version 1.0
 **********************************************************************
 */
public class LabeledFor {

	public static void main(final String[] args) {

		int i = 0;

		outer: for (; true;) {

			inner: for (; i < 10; i++) {
				System.out.println("i = " + i);

				if (i == 2) {
					System.out.println("continue");
					continue;
				}
				if (i == 3) {
					System.out.println("break");
					i++;
					break;
				}
				if (i == 7) {
					System.out.println("continue outer");
					i++;
					continue outer;
				}
				if (i == 8) {
					System.out.println("break outer");
					break outer;
				}
				for (int k = 0; k < 5; k++) {
					if (k == 3) {
						System.out.println("continue inner");
						continue inner;
					}
				}

			}
		}
	}
}
