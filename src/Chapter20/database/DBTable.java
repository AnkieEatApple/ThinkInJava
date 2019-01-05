package Chapter20.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // applies to classes only
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

	public String name() default "";
}
