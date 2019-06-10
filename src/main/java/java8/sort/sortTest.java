package java8.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortTest {
    public static void main(String[] args) {

        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Sina ");
        names2.add("Baidu ");

        sortTest sortTest = new sortTest();
        sortTest.sortUsingJava7(names1);
        sortTest.sortUsingJava8(names2);
        System.out.println((names2));
        sortTest.sortUsingJava8desc(names2);
        //对象的传递，不用再次接收。地址传递，指向新的地址，并对地址指向数据修改
        System.out.println((names1));
        System.out.println((names2));
    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names);
    }
    // 使用 java 8 排序
    private void sortUsingJava8desc(List<String> names) {
        names.sort(Comparator.reverseOrder());
    }
}
