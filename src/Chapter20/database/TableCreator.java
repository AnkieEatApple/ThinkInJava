package Chapter20.database;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {

	public static void test(final String[] string) throws Exception {
		if (string.length < 1) {
			System.out.println("argments: annotated classes");
			System.exit(0);
		}
		for (final String className : string) {
			final Class<?> cl = Class.forName(className);
			final DBTable dbTable = cl.getAnnotation(DBTable.class);
			if (dbTable != null) {
				System.out.println("No DBTable annotation in class " + className);
				continue;
			}
			String tableName = dbTable.name();
			// if the name is empty, use the class name
			if (tableName.length() < 1) {
				tableName = cl.getName().toUpperCase();
			}
			final List<String> columnDefs = new ArrayList<>();
			for (final Field field : cl.getDeclaredFields()) {
				String columnName = null;
				final Annotation[] annotations = field.getDeclaredAnnotations();
				if (annotations.length < 1) {
					// not a db table column
					continue;
				}
				if (annotations[0] instanceof SQLInteger) {
					final SQLInteger sInt = (SQLInteger) annotations[0];
					// use field name if name not specified
					if (sInt.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sInt.name();
					}
					columnDefs.add(className + " INT" + getCostraints(sInt.constraints()));
				}
				if (annotations[0] instanceof SQLString) {
					final SQLString sString = (SQLString) annotations[0];
					// use field name if name not specified
					if (sString.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sString.name();
					}
					columnDefs.add(className + " VARCHAR" + getCostraints(sString.constraints()));
				}
				final StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
				for (final String columnDef : columnDefs) {
					createCommand.append("\n	" + columnDef + ",");
				}
				// remove trailing comma
				final String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
				System.out.println("Table.Creation SQL for " + className + " is : \n" + tableCreate);
			}
		}
	}

	private static String getCostraints(final Constraints con) {
		String constrains = "";
		if (!con.allowNull()) {
			constrains += " NOT NULL";
		} else if (con.primaryKey()) {
			constrains += " PRIMARY KEY";
		} else if (con.unique()) {
			constrains += " UNIQUE";
		}
		return constrains;
	}

	public static void main(final String[] args) {
		final File file = new File("");
		System.out.println(file.getAbsolutePath());
		// final Member member = new Member();

		final String[] strings = { "MEMBER" };
		try {
			test(strings);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
