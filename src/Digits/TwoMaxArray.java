package Digits;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoMaxArray {
    public static int findSecondMax(int[] arr) {
        int max = arr[0]; // max
        int temp = arr[0]; // second max
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                temp = max;
                max = arr[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();


    }

}
