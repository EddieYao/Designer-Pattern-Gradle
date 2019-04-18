package util.beanKitUtilTest;

import util.User;

public class BeanKitTest {

    public static void main(String[] args) {
        User user = new User("1", "yao");

        //传入一个任意对象(不需要知道对象具体类，直接通过属性名获取属性值)
        String id = (String) BeanKit.getProperty(user,"id");
        System.out.println(String.format(id + "----------%s----------",id));
    }
}
