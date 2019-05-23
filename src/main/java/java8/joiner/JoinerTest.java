package java8.joiner;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoinerTest {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        Map testMap = new HashMap<>(3);
        testMap.put("key1","value1");
        testMap.put("key2","value2");
        testMap.put("key3","value3");
        testList.add("1");
        testList.add("2");
        StringBuilder stringBuilder = new StringBuilder("result: ");
        Joiner joiner = Joiner.on(",");
        //必须用个新对象接受，Joiner 实例是不可变的
        String joinStringSb = joiner.appendTo(stringBuilder,testList).toString();
        String joinString = joiner.join(testList);
        //跳过null对象
        joiner.skipNulls().join(testList);
        //map key-value形式输出
        String mapStringResult = joiner.useForNull("None").withKeyValueSeparator("=").join(testMap);
        //对null对象替换为None
        joiner.useForNull("None").join(testList);
        System.out.println(joinString);
        System.out.println(joinStringSb);
        System.out.println(mapStringResult);
    }
}
