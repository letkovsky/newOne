package Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSort {

    // input String[] найти дубликаты и вывести List отсортированный по количеству и потом по значению

    public static List<String> sortMap(List<String> list){
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))//считаем элементы
                .entrySet()//достаем пары слово-количество
                .stream()
                .filter(entry -> entry.getValue() > 1) // ставляем только дубликаты
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))//сначала сортируем по количеству, если равны, то по значению (тут .reversed())
                .map(Map.Entry::getKey)//достаем значения
                .collect(Collectors.toList());
    }
}
