package sql;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author yongqiangyao
 */
public class addTableFieldUtil {
    public final static String insertPrefixMysql = "CALL addTableField(";
    public final static String insertSuffixMysql = "\");";

    public final static String insertPrefixOracle = "ADD_TABLE_COLUMN('";
    public final static String insertSuffixOracle = ");";

    public static void main(String[] args) {
        List<String> ListMysql = new ArrayList<>();
        List<String> ListOracle = new ArrayList<>();

        List<String> resultListMysql = new ArrayList<>();
        List<String> resultListOracle = new ArrayList<>();
        StringBuilder stringbuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine().trim();
            if ("".equals(text)) {
                break;
            }
            stringbuilder.append(text + "\n");
            ListMysql.add(text);
            ListOracle.add(text);
        }
        //mysql
        resultListMysql.add(0, "use bssp;\n");
        ListMysql.stream().forEach(result -> {
            if (result.toUpperCase().contains("ALTER")) {
                int tableIndex = result.toUpperCase().indexOf("TABLE");
                int columnIndex = result.toUpperCase().indexOf("ADD COLUMN");
                String databaseTable = result.substring(tableIndex + 6, columnIndex - 1);
                String databaseName = Arrays.asList(databaseTable.split("\\.")).get(0).trim();
                String tableName = Arrays.asList(databaseTable.split("\\.")).get(1).trim();
                result = result.replace("`", "").replace("\'", "''");
                result = insertPrefixMysql + "\"" + databaseName + "\",\"" + tableName + "\",\"" + result + insertSuffixMysql;
                resultListMysql.add(result + "\n");
            }
        });
        //oracle
        resultListOracle.add(0, "BEGIN\n");
        ListOracle.stream().forEach(resultOracle -> {
            resultOracle = DateUtil.replaceDate(resultOracle);
            resultOracle = resultOracle.replace("\"", "''").replace("`", "").replace("\'", "''");
            if (resultOracle.toUpperCase().contains("ALTER")) {
                int tableIndex = resultOracle.toUpperCase().indexOf("TABLE");
                int columnIndex = resultOracle.toUpperCase().indexOf("ADD COLUMN");
                String databaseTable = resultOracle.substring(tableIndex + 6, columnIndex - 1);
                String tableName = Arrays.asList(databaseTable.split("\\.")).get(1).toUpperCase().trim();
                String columnNameStr = resultOracle.substring(resultOracle.toUpperCase().indexOf("ADD COLUMN") + 10, resultOracle.indexOf(";"));
                String columnName = columnNameStr.substring(columnNameStr.indexOf(" ") + 1, columnNameStr.lastIndexOf(" ")).toUpperCase().trim();
                resultOracle = resultOracle.replace("`", "");
                resultOracle = resultOracle.replace(";", "");
                resultOracle = insertPrefixOracle + tableName + "\",\"" + columnName + "\",\"" + resultOracle + "\"" + insertSuffixOracle;
                resultListOracle.add(resultOracle + "\n");
            }
        });
        resultListOracle.add(resultListOracle.size(), "END;\n/");

        String oracleStr = Joiner.on("").join(resultListOracle);
        System.out.println(oracleStr);

        String mysqlStr = Joiner.on("").join(resultListMysql);
        System.out.println(mysqlStr);

    }
}
