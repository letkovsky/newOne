package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
                        .filter(e -> e.getValue().equals(temp))
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


    public static void main(String[] args) {
        int[] ints = {3, 5, 7, 9, 14};
        int num = 19;
        System.out.println(Arrays.toString(searchInd(ints, num)));

    }
}
