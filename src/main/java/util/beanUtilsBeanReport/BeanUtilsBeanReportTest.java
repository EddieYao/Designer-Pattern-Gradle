package util.beanUtilsBeanReport;

import util.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanUtilsBeanReportTest {

    public static void main(String[] args){
        try {
            User user = new User("2", "yao");
            Map resultMap = BeanUtilsBeanReport.getInstance().describe(user);
            List<User> userList = new ArrayList<>();
            userList.add(user);
            userList.add(user);
            List mapList = new ArrayList();
            //一个List元素中可以包含多个map(一对多)，一个List集合可以有多个元素
            for (User userMap:userList){
                //这个mapList元素中包含user中三个属性的map值(即3个map对象 key为属性名 value为属性值)
                mapList.add(BeanUtilsBeanReport.getInstance().describe(userMap));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
