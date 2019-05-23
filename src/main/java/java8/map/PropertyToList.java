package java8.map;

import java8.reduce.Reduce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyToList {
    public static void main(String[] args) {
        // 将List中某个属性取出转成一个List集合
        List<Reduce> reducesList = new ArrayList<>();
        Reduce reduce = new Reduce(new BigDecimal(1), 1);
        Reduce reduce1 = new Reduce(new BigDecimal(2), 2);
        reducesList.add(reduce);
        reducesList.add(reduce1);
        List countList = reducesList.stream().map(Reduce::getCount).collect(Collectors.toList());
        List moneyList = reducesList.stream().map(Reduce::getMoney).collect(Collectors.toList());
    }
}
