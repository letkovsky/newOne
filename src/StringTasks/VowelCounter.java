package StringTasks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class VowelCounter {

    public static int vowelCount(String str){
        long count = Arrays.stream(str.split(""))
                .filter(c -> "AEIOU".contains(c.toUpperCase()))
                .count();

        return (int) count;
    }

    public static void main(String[] args) {
        int[] ints = new int[5];

        String s = "jav    va";
        List<String> list = new ArrayList<>();

        s = s.replaceAll(" ", "");

        int count = vowelCount(s);
        int consCount = s.length() - count;
        System.out.println("number of vowels : " + count);
        System.out.println("number of consonants : " + consCount);

    }
}
