package Chapter20.database;

public @interface Uniqueness {
	Constraints constraints() default @Constraints(unique = true);
}
