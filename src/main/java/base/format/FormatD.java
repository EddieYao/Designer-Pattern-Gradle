package base.format;

public class FormatD {
    public static void main(String[] args) {
//        对整数进行格式化：%[index$][标识][最小宽度]转换方式
//        格式化字符串由4部分组成，特殊的格式常以%index$开头，index从1开始取值，表示将第index个参数拿进来进行格式化，[最小宽度]的含义也很好理解，就是最终该整数转化的字符串最少包含多少位数字。剩下2个部分的含义：
//        标识：
//
//        '-' 在最小宽度内左对齐，不可以与"用0填充"同时使用
//        '#' 只适用于8进制和16进制，8进制时在结果前面增加一个0，16进制时在结果前面增加0x
//        '+' 结果总是包括一个符号(一般情况下只适用于10进制，若对象为BigInteger才可以用于8进制和16进制)
//        ' ' 正值前加空格，负值前加负号(一般情况下只适用于10进制，若对象为BigInteger才可以用于8进制和16进制)
//        '0' 结果将用零来填充
//        ',' 只适用于10进制，每3位数字之间用"，"分隔
//        '(' 若参数是负数，则结果中不添加负号而是用圆括号把数字括起来(同'+'具有同样的限制)
//        转换方式：
//
//        d-十进制 o-八进制 x或X-十六进制

        long number = 0;
        String newNumStr = String.format("%04d",456);

        // 从第一位开始格式化，
        System.out.println(String.format("%1$09d", 312356));

        // 0 填充
        System.out.println(String.format("%1$011d", 312356,66666));

        // 2代表第二个值格式化
        System.out.println(String.format("%2$011d", 312356,66666));
        System.out.println(newNumStr);
    }
}
