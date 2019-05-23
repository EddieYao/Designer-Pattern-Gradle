package java8.map;

import java8.reduce.Reduce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ListFilterToObject {
    public static void main(String[] args) {
        // 将List中取出符合条件的对象
        List<Reduce> reducesList = new ArrayList<>();
        Reduce reduce = new Reduce(new BigDecimal(1), 1);
        Reduce reduce1 = new Reduce(new BigDecimal(2), 2);
        reducesList.add(reduce);
        reducesList.add(reduce1);

        reducesList.stream().filter(reduce2 -> reduce2.getCount().equals(1)).findAny().orElse(null);

        reducesList.stream().filter(reduce2 -> {
            String str = reduce2.getCount().toString()+reduce2.getMoney();
            boolean flag = str.equals("test");
            return flag;
        }).findAny().orElse(null);
    }
}
