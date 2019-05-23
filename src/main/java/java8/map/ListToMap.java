package java8.map;

import java8.reduce.Reduce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        // 将List中转成map
        List<Reduce> reducesList = new ArrayList<>();
        Reduce reduce = new Reduce(new BigDecimal(1), 1);
        Reduce reduce1 = new Reduce(new BigDecimal(2), 2);
        reducesList.add(reduce);
        reducesList.add(reduce1);

        Map<Integer, Reduce> reduceMap = reducesList.stream().collect(Collectors.toMap(Reduce::getCount, Function.identity(), (oldValue, newValue) -> newValue));
        Map<Integer, Reduce> reduceNewValueMap = reducesList.stream().collect(Collectors.toMap(Reduce::getCount, Function.identity()));

        //List转Map，同时key做逻辑校验
        Map<String, Reduce> stringReduceMap = reducesList.stream().collect(Collectors.toMap(reduceResult -> {
            String str = reduceResult.getCount().toString() + reduceResult.getMoney().toString();
            if (reduceResult.getCount() == 1) {
                str += "test";
            }
            return str;
        }, Function.identity()));

        Map<String, Reduce> stringReduceDtMap = reducesList.stream().collect(Collectors.toMap(reduceResult -> {
            String str = reduceResult.getCount().toString() + reduceResult.getMoney().toString();
            if (reduceResult.getCount() == 1) {
                str += "test";
            }
            return str;
        }, reduce2 -> reduce2));

        Map<String, Reduce> stringReduceFucntionMap = reducesList.stream().collect(Collectors.toMap(reduceResult -> {
            String str = reduceResult.getCount().toString() + reduceResult.getMoney().toString();
            if (reduceResult.getCount() == 1) {
                str += "test";
            }
            return str;
        }, Function.identity(), (oldValue, newValue) -> newValue));
    }
}
