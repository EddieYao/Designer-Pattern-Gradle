package util.beanUtils;


import org.springframework.beans.BeanUtils;

public class beanUtilsTest {
    public static void main(String[] args){
        UserString userString = new UserString("1");
        UserBigDecimal userBigDecimal = new UserBigDecimal();
        BeanUtils.copyProperties(userString,userBigDecimal);
        System.out.println(userString.getId()+"---------------"+userBigDecimal.getId());
    }
}
