package Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NotDuplicate {


    public static List<Integer> findDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> listDuplicate = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) {
                listDuplicate.add(arr[i]);
            }
        }
        return listDuplicate;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8, 9, 10, 10, 12, 14, 15};



        List<Integer> duplicate = findDuplicate(nums);// находим дубликаты в коллекции
        System.out.println(duplicate);


        List<Integer> sorted = Arrays.stream(nums)
                .sorted()
                .boxed()
                .collect(Collectors.toList());   //сортируем колекцию по возрастанию


        System.out.println(sorted);
        Integer maxValue = sorted.get(sorted.size() - 1);
        int i = sorted.indexOf(maxValue / 2);
        List<Integer> condList = sorted.subList(0, i + 1);
        System.out.println(condList);


        List<Integer> collect = condList.stream()
                .filter(e -> sorted.contains(e * 2)) // фильтр  содержится ли значение в исходной коллекции
                .filter(e -> !duplicate.contains(e * 2)) // проверка на дубликаты
                .collect(Collectors.toList());

        System.out.println(collect);


    }
}


