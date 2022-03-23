package Test;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {

    interface Operationable {
        int calculate(int x, int y);
    }

    interface Printable {
        void print(String s);
    }

    public static String removeDuplicates(String string) {
        if (string == null) {
            return null;
        }
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        char previous = ' ';

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == previous){
                previous = chars[i];
                continue;
            }
            stringBuilder.append(chars[i]);
            previous = chars[i];

        }

        return stringBuilder.toString();
    }


        public static void main (String[]args){
//        TestOne testOne = new TestOne();
//        testOne.go();
//            String test = "jjaavvvaa";
//            System.out.println(removeDuplicates(test));
//
//
//            String s1 = "aaa";
//            String s2 = "aaa";
//            String s3 = new String("aaa");
//            String s6 = new String("aaa");
//            String s4 = new String("aaa").intern();
//            String s5 = String.valueOf("aaa");
//
//            System.out.println(s1.equals(s6));
//
//
//            Operationable operation = (x, y) -> x + y;
//            System.out.println(operation.calculate(2, 5));
//
//            List<String> list = new ArrayList<String>();
//            list.add("test");
//            list.add("testtesttest");
//            list.add("testtest");
//            System.out.println(list);
//            Collections.sort(list, (b, a) -> a.compareTo(b));
//
//            System.out.println(list);
//
//            List<Integer> collect = Stream.iterate(1, integer -> integer + 1)
//                    .limit(10)
//                    .collect(Collectors.toList());
//            System.out.println(collect);
//
//
//            List<String> fromGenerate = Stream.generate(() -> "0").limit(10).collect(Collectors.toList());
//            System.out.println(fromGenerate);
//
//
//            int[] nums = new int[]{1, 3, 2, 5, 7};//
////
//
//
//            int asInt = Arrays.stream(nums)
//                    .sum();
//
//            System.out.println(asInt);
//
//            Integer[] integers1 = Arrays.stream(nums)
//                    .boxed()
//                    .toArray(Integer[]::new);
//
//            Integer[] integers = new Random()
//                    .ints(0, 10)
//                    .limit(10)
//                    .boxed()
//                    .toArray(Integer[]::new);


            List<Integer> collect1 = Stream.generate(() -> new Random().nextInt(100))
                    .distinct()
                    .limit(10)
                    .collect(Collectors.toList());
            Collections.sort(collect1);
            System.out.println(collect1);


        }
    }
