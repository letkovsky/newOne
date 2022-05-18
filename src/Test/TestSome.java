package Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSome {


    public static void main(String[] args) {

        String s = "ffmmmmmvaaaaa";

        String[] split = s.split("");
        Set<String> set = new HashSet<>();
        Set<String> collect2 = Arrays.stream(split)
                .map(String::toLowerCase)
                .filter(e -> !set.add(e))
                .collect(Collectors.toSet());
        System.out.println(collect2);

        List<Map.Entry<String, Long>> collect = Arrays.stream(split)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .collect(Collectors.toList());
        System.out.println(collect);


        List<Integer> strings = List.of(3, 4, 1, 0, 7, 2);
        List<Integer> collect1 = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(collect1);

        int[] nums = new int[]{1,2,3,4,5};
        List<Integer> collect3 = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        int[] ints = collect3.stream().mapToInt(x -> x).toArray();


    }
}

