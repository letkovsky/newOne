package Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicate {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 4, 5, 5);
        System.out.println(findOne(list));
        System.out.println(findTwo(list));
        System.out.println(findThree(list));
    }

    public static <T> Set<T> findOne(Collection<T> collection) {
        Set<T> set = new HashSet<>();
        return collection.stream()
                .filter(e -> !set.add(e))
                .collect(Collectors.toSet());
    }

    public static <T> Set<T> findTwo(Collection<T> collection) {
        return collection.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))// почитать разобраться что это такое
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static <T> Set<T> findThree(Collection<T> collection) {
        return collection.stream()
                .filter(e -> Collections.frequency(collection, e) > 1)
                .collect(Collectors.toSet());
    }
}
