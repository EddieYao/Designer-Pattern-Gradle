package reflection;

import java.lang.reflect.Constructor;

/**
 * @author yyq
 */
public class main {
    public static void main(String[] args) throws Exception {

        // 第一种
        Class clz = Class.forName("reflection.reflection");
        reflection ref = (reflection) clz.newInstance();
        ref.test();
        // 第二种
        Constructor constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        ((reflection)object).test();
    }
}
