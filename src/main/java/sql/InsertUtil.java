package sql;

/**
 * @author yongqiangyao
 */
public class InsertUtil {
    public final static String insertPrefixMysql = "call insertTable('";
    public final static String insertSuffixMysql = "');";

    public final static String insertPrefixOracle = "TABLE_INSERT('";
    public final static String insertSuffixOracle = "');";

    public static void main(String[] args) {
       int number = Integer.parseInt("2019158911");
        System.out.println(number);

    }
}
