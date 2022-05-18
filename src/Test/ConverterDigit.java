package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConverterDigit {
    //   task: Given a random non-negative number, you have to return the digits of this number within an array in reverse order.
    //   Example:
    //   348597 => [7,9,5,8,4,3]
    //   0 => [0]

    public static int[] digitize(long n) {
        //decision from codewars with Stream API
        return new StringBuilder()
                .append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static int[] digitize2(long n) {
        // my math decision
        List<Integer> list = new ArrayList<>();
        long reverseNum = 0;
        while (n > 0) {
            long l = n % 10;
            reverseNum = reverseNum + l;
            list.add((int) l);
            n = n / 10;
            if (n == 0) break;
            reverseNum = reverseNum * 10;
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
    public static int[] digitize3(long n){
        // with String
        String s = String.valueOf(n);
        String[] split = s.split("");
        int[] digits = new int[s.length()];
        for (int i = split.length - 1; i >= 0 ; i--){
            digits[digits.length - 1 - i] = Integer.parseInt(split[i]);
        }
        return digits;
    }

    public static int[] digitize4(long n){
        // with String
        String s = String.valueOf(n);


        int[] digits = new int[s.length()];
        for (int i = s.length() - 1; i >= 0 ; i--){

            digits[digits.length - 1 - i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return digits;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(digitize4(1234)));
    }

}
