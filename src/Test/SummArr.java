package Test;

import java.util.*;
import java.util.stream.Collectors;

public class SummArr {

    // The method should return indices of the two numbers such that they add up to the target, where index1
    // must be less than index2.
    //Example [2,7,11,15], 13 -> [0,2]

    public static int[] searchInd(int[] arr, int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsValue(num - arr[i])) {
                int temp = num - arr[i];


                Optional<Integer> first = map.entrySet().stream()
                        .filter(e -> e.getValue() == temp) // e.getValue().equals(temp)
                        .map(Map.Entry::getKey)
                        .findFirst();
                if (first.isPresent()) {
                    result[0] = first.get();
                    result[1] = i;
                    return result;
                }


            } else {
                map.put(i, arr[i]);
            }
        }
        return null;
    }


    public static int[] searchDigits( int[] arr, int sum){
        int[] result = new int[2];
       HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(sum - arr[i])){
                result[0] = sum - arr[i];
                result[1] = arr[i];
                map.put(sum - arr[i], arr[i]);
            } else {
                set.add(arr[i]);
            }

        }

        System.out.println(map);
        System.out.println(collect);
        System.out.println(set);
        return result;
    }


    public static void main(String[] args) {
        int[] ints = {3, 5,16, 7, 9,10,14, 12};
        int num = 19;
        System.out.println(Arrays.toString(searchDigits(ints, num)));

    }
}
