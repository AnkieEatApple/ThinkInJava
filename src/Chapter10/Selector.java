package Chapter10;

/**
 ********************************************************************** 
 * @Title: Selector.java
 * @Description:
 * @author ankie
 * @date 2018年12月11日
 * @version 1.0
 **********************************************************************
 */
public interface Selector {
	boolean end();

	Object current();

	void next();
}
