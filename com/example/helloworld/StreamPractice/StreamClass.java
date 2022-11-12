package com.example.helloworld.StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamClass {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,3,4,5,1,5,20,-4,-2,-7);
        Stream<Integer> data = list.stream();
//        ========count data=======
//        long cnt = data.count();
//        System.out.println(cnt);

//        =========sort the stream=========
//        Stream<Integer> sorted = data.sorted();

//        =========map============
        Stream<Integer> mappedStream = data.map(p -> p * 2);

        mappedStream.forEach(n-> System.out.println(n));

//        =========single line======
        list.stream()
                .sorted()
                .map(p->p*2)
                .forEach(System.out::println);

//        =======printing only odd number======
        System.out.println("Printing only odd number");
        Function<Integer,Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*10;
            }
        };
        list.stream()
                .filter(p->p%2!=0 && p>=0)
                .sorted()
                .map(function)
                .forEach(System.out::println);
//      ========using reduce======
        System.out.println("using reduce");
        Integer result = list.stream()
                .filter(p -> p % 2 != 0 && p >= 0)
                .sorted()
                .map(p -> p * 10)
                .reduce(0, (c, e) -> c + e);
        System.out.println(result);
//        data.filter(n->n%2==0).forEach(n-> System.out.println(n));
    }
}
