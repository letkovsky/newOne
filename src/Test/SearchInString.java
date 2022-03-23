package Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchInString {

    public static void main(String[] args) {
        String x = "ABC";
        String y = "ACDGGHHABCABCLLABCABCABC";
        boolean flag = false;
        int maxCount = 0;
        Set<Integer> set = new HashSet<>();

        StringBuilder st = new StringBuilder();



        while (y.indexOf(x) != -1) {

            int i = y.indexOf(x);
            int count = 1;
            y = y.substring(i);
            if (i == 0) {
                y = y.substring(x.length());
                set.add(++count);
            }

            System.out.println(y);
        }

        System.out.println(set);

    }


    public static int searchRepeat(String little, String big) {
        int i = big.indexOf(little);


        return 0;
    }
}
