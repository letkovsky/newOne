package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseStr {
    public static String reverseInputStr(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseInputStr2(String str){
        String s = "";
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--){
            s = s + chars[i];
        }
        return s;
    }

}
