package Digits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArray {
    public static int[] swap(int[] ints, int ind) {
        return null;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5 ,0,0,0};
        int offset = 1;
        int temp = ints[ints.length - 1];
        for (int i = ints.length - 1; i >= 0; i--) {
            if (i == 0) {
                ints[0] = temp;
                break;
            }
            ints[i] = ints[i - 1];
        }

        System.out.println(Arrays.toString(ints));
        int[] ints1 = new int[5];
        System.out.println(Arrays.toString(ints1));


    }
}




