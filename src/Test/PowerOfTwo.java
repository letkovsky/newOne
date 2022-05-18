package Test;

import java.util.List;

public class PowerOfTwo {
    private static int power = 0;
    public static boolean isPowerOfTwo(int num) {
        int count = 0;
        if (num <= 1) return false;

        while (num >= 2) {

                if (num % 2 == 0) {
                    power = ++count;

                } else {
                    power = 0;
                    return false;
                }
            num = num / 2;
        }
        return true;
    }

    public static double log2(int n){
        return (Math.log(n) / Math.log(2));
    }

    public static void main(String[] args) {
        List<String> one = List.of("one", "two", "three");
        String[] strings1 = one.toArray(String[]::new);
        String[] strings = one.toArray(one.toArray(new String[0]));


    }

}
