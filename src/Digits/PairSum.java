package Digits;



// How to find all pairs which add up to a given value in an Integer Array

import java.util.*;

public class PairSum {

    private static class Pair{
        int x1;
        int x2;

        public Pair(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x1=" + x1 +
                    ", x2=" + x2 +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 8, 5, 6, 7, 4, 9};
        int x = 6;
        System.out.println(findPairs(ints, x));
        Map<Integer, Integer> pairs = findPairs(ints, x);
        pairs
                .entrySet()
                .stream()
                .forEach(i -> {
                    System.out.println("Pair :" + i.getKey() + " & " + i.getValue());
                }
                );


        ArrayList<Integer> objects = new ArrayList<>();

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> copy = new ArrayList<>(integers);

        copy.add(1);
        System.out.println(integers);
        System.out.println(copy);
        System.out.println(new Pair(1, 2));

    }





    public static Map<Integer, Integer> findPairs(int[] arr, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            if (arr[left] + arr[right] == sum){
                map.put(arr[left], arr[right]);
                left =  left + 1;
            } else if (arr[left] + arr[right] > sum){
                right = right - 1;
            } else {
                left = left + 1;
            }
        }
        return map;
    }
}
