package wsb;

import java.lang.reflect.Field;

public class ObjectToSqlConverter {
    public String insert(Object object){

        //INSERT INTO table_name(column_1, column_2, ...)
        //VALUES (value_1, value_2, ...)

        StringBuilder values = new StringBuilder();
        StringBuilder columns = new StringBuilder();

        for (Field field: object.getClass().getDeclaredFields()){
            if (field.isAnnotationPresent(Mapped.class)) {
                field.setAccessible(true);
                try {
                    String tempVal = String.format("%s, ", field.get(object));
                    String tempCol = String.format("%s, ", field.getName());
                    values.append(tempVal);
                    columns.append(tempCol);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        String sql = String.format("INSERT INTO %s(%s) VALUES(%s)", object.getClass().getSimpleName(),columns.toString(), values.toString());
        return sql;
    }
}
