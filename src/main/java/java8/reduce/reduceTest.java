package java8.reduce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class reduceTest {
    public static void main(String[] args) {

        // 获取一个集合中的某个属性和
        List<Reduce> reducesList = new ArrayList<>();
        Reduce reduce = new Reduce(new BigDecimal(1),1);
        Reduce reduce1 = new Reduce(new BigDecimal(2),2);
        reducesList.add(reduce);
        reducesList.add(reduce1);
        BigDecimal moneyAll = reducesList.stream().map(Reduce::getMoney).reduce(BigDecimal.ZERO,BigDecimal::add);
        Integer countAll = reducesList.stream().map(Reduce::getCount).reduce(0,Integer::sum);



        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        Integer maxReduce = costBeforeTax.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println(maxReduce);

        //构造字符串流
        List<String> strs = Arrays.asList("H", "E", "L", "L", "O");

        // reduce
        String concatReduce = strs.stream().reduce("", String::concat);
        System.out.println(concatReduce);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        // 没有起始值时返回为Optional类型
        Optional<Integer> sumOptional = integers.stream().reduce(Integer::sum);
        System.out.println(sumOptional.get());

    }
}
