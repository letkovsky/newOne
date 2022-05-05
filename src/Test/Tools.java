package Test;

import java.util.*;
import java.util.stream.Collectors;

public class Tools {
    private static Scanner s = new Scanner(System.in);

    public static void Writer(String message) {
        System.out.println(message);
    }

    public static int readInt() {
        return s.nextInt();
    }

    public static double readDouble() {
        return s.nextDouble();
    }


    public static void main(String[] args) {
        String s = "BBBBBBBAACCCCC";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> collect = entries.stream()
                .sorted((Comparator.comparingInt(Map.Entry::getValue)))
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println(map);


        Comparator<Cat> comparator = new Comparator<>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getX() - o2.getX();
            }
        };
        Comparator<Cat> comparing = Comparator.comparing(o -> o.getX());
        Comparator<Cat> comparator2 = (o1, o2) -> o1.getX() - o2.getX();
        Comparator<Cat> comparator1 = Comparator.comparing(Cat::getX);
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1));
        cats.add(new Cat(4));

        cats.add(new Cat(3));
        cats.add(new Cat(0));
        List<Cat> cats1 = List.of(new Cat(1), new Cat(4), new Cat(3), new Cat(0));
        System.out.println(cats);
        cats.sort(comparator1);
        System.out.println(cats);
    }

}
