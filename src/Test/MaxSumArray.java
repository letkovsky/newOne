package Test;

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

        for(int a : arr) {
            sum += a;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}
