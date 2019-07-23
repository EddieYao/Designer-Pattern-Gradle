package sql;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    public static Pattern p = Pattern.compile("^.*\"[1-2][0-9][0-9][0-9]-([1][0-2]|0?[1-9])-([12][0-9]|3[01]|0?[1-9]) ([01][0-9]|[2][0-3]):[0-5][0-9]:[0-5][0-9].*$");

    public static boolean isDate(String date) {
        return p.matcher(date).matches();
    }

    public static void main(String[] args) {
        String str = ",,,,,,\"2019-04-09 15:05:05\",,,,,";
        Matcher matcher = p.matcher(str);
        if (matcher.find()) {
            String groupMonth = matcher.group(1);
            String groupDay = matcher.group(2);
            String monthDay = groupMonth + "-" + groupDay;
            String result = str.substring(str.indexOf(monthDay) - 6, str.indexOf(monthDay) + 15);
            str = str.replace(result, "NULL");
            System.out.println(str);
        }
    }

    public static String replaceDate(String str) {
        Matcher matcher = p.matcher(str);
        if (matcher.find()) {
            String groupMonth = matcher.group(1);
            String groupDay = matcher.group(2);
            String monthDay = groupMonth + "-" + groupDay;
            String result = str.substring(str.indexOf(monthDay) - 6, str.indexOf(monthDay) + 15);
            str = str.replace(result, "NULL");
            System.out.println(str);
        }
        return str;
    }
}
