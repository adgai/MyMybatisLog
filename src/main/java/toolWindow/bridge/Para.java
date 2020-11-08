package toolWindow.bridge;

/**
 * @Description :
 * @Author :zhanglei6
 * @Date :2020/11/1 22:37
 **/
public class Para {
    public String value;
    public String type;


    public String replace( String sql) {
        String finalValue = value.trim();
        if (type.contains("String")) {
            finalValue = "'" + value + "'";
        }else if (type.contains("Date")){
            finalValue = "'" + value + "'";

        }

        String replacedSql = sql.replaceFirst("\\?", finalValue);

        return replacedSql;
    }
}
