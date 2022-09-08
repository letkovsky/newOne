package Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubstringArray {
    // task:    Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
    //
    //          Example 1:
    //          a1 = ["arp", "live", "strong"]
    //          a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
    //          returns ["arp", "live", "strong"]


    public static String[] WhichAreIn1(String[] a, String[] b) {
        // my decision
        Set<String> result = new HashSet<>();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (b[i].contains(a[j])) {    // contains() may be changed to indexOf(str) != -1
                    result.add(a[j]);
                }
            }
        }
        return result.stream().sorted().toArray(String[]::new);
    }

    public static String[] WhichAreIn2(String[] a, String[] b){
        // decision from codewars with stream API
        return Arrays.stream(a)
                .filter(str1 -> Arrays.stream(b).anyMatch(str2 -> str2.contains(str1))) //
                .distinct()
                .sorted()
                .toArray(String[]::new);
    }


}
