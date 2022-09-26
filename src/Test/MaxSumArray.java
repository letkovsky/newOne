package Test;

import java.util.*;
import java.util.stream.Collectors;

public class MaxSumArray {


    public static int maxSum2(int[] ints) {

        int max = 0;
        int sum = 0;

        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }


    public static int maxSum(int[] arr) {

        int sum = 0;
        int max = 0;

        for (int a : arr) {
            sum += a;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }

    // subArray of max sum
    // [1,2,5,0,-4] => [1,2,5,0] and sum = 8;

    public static int[] subArrayOfMaxSum(int[] arr) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int sum = 0;
        int maxSum = 0;
        int size = 0;
        int[] ints = new int[arr.length];
        int[] intsMax = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= maxSum){
                maxSum = sum;
                ints[size++] = arr[i];
//                intsMax = Arrays.copyOf(ints, ints.length);
                map.put(maxSum, ints);

            } else {
                Arrays.fill(ints, 0);
                sum = 0;
                maxSum = 0;
                size = 0;
            }
        }

        Optional<Map.Entry<Integer, int[]>> max1 = map.entrySet().stream().max(Map.Entry.comparingByKey());
        if (max1.isPresent()){
            System.out.println(max1.get().getKey() + " " + Arrays.toString(max1.get().getValue()));
            int[] value = max1.get().getValue();
            int[] ints1 = Arrays.stream(value).boxed().filter(value1 -> value1 != 0).mapToInt(x -> x).toArray();
            System.out.println(Arrays.toString(ints1));


        }
        Integer max2 = Collections.max(map.keySet());




        Optional<Integer> max = map.keySet().stream().max(Integer::compareTo);
        if (max.isPresent()){
            Integer maxKey = max.get();
            int[] ints1 = map.get(maxKey);
            System.out.println(maxKey);


            return ints1;
        }


        return new int[0] ;


//        return integersMaxSum.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,21, 2, -1, -4,7,22,3};
        System.out.println(maxSum(arr));
        System.out.println(Arrays.toString(subArrayOfMaxSum(arr)));
    }
}
