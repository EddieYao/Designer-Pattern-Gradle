package sql;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yongqiangyao
 */
public class InsertUtil {
    public final static String insertPrefixMysql = "call insertTable('";
    public final static String insertSuffixMysql = "');";

    public final static String insertPrefixOracle = "TABLE_INSERT('";
    public final static String insertSuffixOracle = "');";

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
            if (result.toUpperCase().contains("INSERT")) {
                result = result.replace("`","").replace("\'", "''");
                result = insertPrefixMysql + result + insertSuffixMysql;
                resultListMysql.add(result+"\n");
            }
        });
        //oracle
        resultListOracle.add(0, "BEGIN\n");
        ListOracle.stream().forEach(resultOracle -> {
            if (resultOracle.toUpperCase().contains("VALUES")) {
                int insertIndex = resultOracle.toUpperCase().indexOf("INSERT");
                int valueIndex = resultOracle.toUpperCase().indexOf("VALUES");
                resultOracle = resultOracle.substring(insertIndex,valueIndex+6).toUpperCase()+resultOracle.substring(valueIndex+6,resultOracle.length());
            }
            resultOracle = DateUtil.replaceDate(resultOracle);
            resultOracle = resultOracle.replace(";", "").replace("\"", "''").replace("`","").replace("\'", "''");
            if (resultOracle.toUpperCase().contains("INSERT")) {
                resultOracle = insertPrefixOracle + resultOracle + insertSuffixOracle;
                resultListOracle.add(resultOracle+"\n");
            }
        });
        resultListOracle.add(resultListOracle.size(), "END;\n/");

        String oracleStr = Joiner.on("").join(resultListOracle);
        System.out.println(oracleStr);

        String mysqlStr = Joiner.on("").join(resultListMysql);
        System.out.println(mysqlStr);

    }
}
