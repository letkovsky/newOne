package Digits;

import java.util.Arrays;

public class SlavikApi {

    public static Result getMultiplyExceptOne(int[] nums) {
        int iterations = 0;

        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        int s = 1;
        for (int i = 1; i < n; i++)  {
            ++iterations;
            s *= nums[i-1];
            res[i] = s;
        }

        s = 1;
        for (int i = n - 2; i >= 0; i--) {
            ++iterations;
            s *= nums[i+1];
            res[i] *= s;
        }

        return new Result(iterations, res);
    }

    public static void main(String[] args) {
        Result r = getMultiplyExceptOne(new int[]{2,3,4,5});

        System.out.println(Arrays.toString(r.res));
        System.out.println("Iterations: "+ r.iterations);
    }
}
