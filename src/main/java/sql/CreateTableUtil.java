package sql;

import org.springframework.util.StringUtils;

import java.util.*;

public class CreateTableUtil {
    public final static String createPrefixMysql = " IF NOT EXISTS";

    public final static String createSuffixOracle = "CREATE_TABLE ('";

    public static void main(String[] args) {
        String tableNameResult;
        List<String> ListMysql = new ArrayList<>();
        List<String> ListOracle = new ArrayList<>();

        List<String> resultListMysql = new ArrayList<>();
        List<String> resultListOracle = new ArrayList<>();
        List resultListCommentOracle = new ArrayList<>();
        StringBuilder stringbuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine().trim();
            if ("Y".equals(text)) {
                break;
            }
            stringbuilder.append(text + "\n");
            ListMysql.add(text);
            ListOracle.add(text.toUpperCase());
        }
        //mysql
        ListMysql.stream().forEach(result -> {
            if (result.toUpperCase().contains("CREATE TABLE")) {
                result = result.replace("CREATE TABLE", "CREATE TABLE" + createPrefixMysql).replace("`", "");
            }
            resultListMysql.add(result);
        });
        //oracle
        resultListOracle.add(0, "BEGIN");
        Map<String, String> commentMap = new HashMap<>();
        ListOracle.stream().forEach(resultOracle -> {
            int i = 1;
            resultOracle = DateUtil.replaceDate(resultOracle);
            resultOracle = resultOracle.toUpperCase().replace(";", "").replace("\"", "''").replace("`", "").replace("\'", "''").replace("VARCHAR", "NVARCHAR").replace("DEFAULT", "");
            if (resultOracle.toUpperCase().contains("COMMENT") && !resultOracle.toUpperCase().contains("ENGINE")) {
                String comment = resultOracle.substring(resultOracle.indexOf("COMMENT") + 9, resultOracle.lastIndexOf(",") - 1);
                resultOracle = resultOracle.replace("''" + comment + "''", "");
                String columnName = null;
                if ((resultOracle.toUpperCase().contains("NVARCHAR")) && !StringUtils.isEmpty(resultOracle.substring(0, resultOracle.indexOf("NVARCHAR")))) {
                    columnName = resultOracle.substring(0, resultOracle.indexOf("NVARCHAR"));
                } else if ((resultOracle.toUpperCase().contains("DECIMAL")) && !StringUtils.isEmpty(resultOracle.substring(0, resultOracle.indexOf("DECIMAL")))) {
                    columnName = resultOracle.substring(0, resultOracle.indexOf("DECIMAL"));
                } else if ((resultOracle.toUpperCase().contains("TEXT")) && !StringUtils.isEmpty(resultOracle.substring(0, resultOracle.indexOf("TEXT")))) {
                    columnName = resultOracle.substring(0, resultOracle.indexOf("TEXT"));
                }
                resultOracle = resultOracle.replace(resultOracle.substring(resultOracle.indexOf("COMMENT") + 8, resultOracle.lastIndexOf(",")), "").replace("COMMENT", "");
                commentMap.put(columnName, comment);
            }
            if (resultOracle.toUpperCase().contains("CREATE TABLE")) {
                String tableName = resultOracle.substring(resultOracle.indexOf("CREATE TABLE") + 13, resultOracle.indexOf("(") - 1);
                tableName = tableName.replace(" ", "");
                resultListOracle.add(createSuffixOracle + tableName + "'," + "'" + resultOracle);
            } else {
                resultListOracle.add(resultOracle);
            }
            i++;
        });
        resultListCommentOracle.add("COMMENT ON TABLE ");
        for (Map.Entry<String, String> entry : commentMap.entrySet()) {
            resultListCommentOracle.add("COMMENT ON COLUMN .\"" + entry.getKey() + "\" IS " + "\'" + entry.getValue() + "\'");
        }
        resultListOracle.add(resultListOracle.size(), "END;\n/");
        resultListOracle.stream().forEach(resultOracle -> {
            System.out.println(resultOracle);
        });
//        resultListMysql.stream().forEach(result -> {
//            System.out.println(result);
//        });
    }
}
