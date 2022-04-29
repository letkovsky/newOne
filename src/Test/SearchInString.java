package Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchInString {

    public static void main(String[] args) {
//        String x = "test";
//        String y = "BCVVVVVtesttestBB";
        HashSet<Integer> set = new HashSet<>();
//        List<String> list = new ArrayList<>();
//        System.out.println(searchRepeat(x, y));
//        String t = "testmytest";
//
//
//        System.out.println(list);
//
//
//
        String ss = "fgbestbestbnlkbestBB";
        String pat = "best";
        int index;
        int curInd = 0;


        int max = 0;
        int counter = 0;

        while ((index = ss.indexOf(pat,curInd)) != -1) {
            if (index == 0) {
                curInd = index + pat.length();
                continue;
            }



            if (index == curInd){
                counter++;
                if (counter > max){
                    max = counter;
                }
                set.add(counter);
            }else {

                counter = 0;
            }
            curInd = index + pat.length();
        }
        System.out.println(set);
        OptionalInt max1 = set.stream().mapToInt(v -> v).max();
        int i = max1.isEmpty() ? 0 : max1.getAsInt() + 1;

        System.out.println(pat + "-" + i);
        System.out.println();
        System.out.println(max + 1);


    }


    public static int searchRepeat(String little, String big) {

        HashMap<String,Integer> map = new HashMap<>();


        String abc = big.replaceAll(little, "1");// заменяем подстроку little на 1
        String[] split = abc.split("");
        System.out.println(Arrays.toString(split));

        String previous = " ";
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(previous)) {
                map.put(previous,map.get(previous) + 1);
            }else {
                map.put(split[i], 1);
            }
            previous = split[i];
        }
        System.out.println(map);


        return map.getOrDefault("1", 0);
//        HashSet<Integer> set = new HashSet<>();
//        String s = big.replaceAll(little, "0");
//        char[] chars = s.toCharArray();
//        char previous = ' ';
//        int count = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] != previous){
//                count = 0;
//            }
//            if (chars[i] == previous & previous == '0'){
//                count++;
//                set.add(count);
//
//            }
//            previous = chars[i];
//        }
//        System.out.println(set);
//        return set.stream().mapToInt(v -> v).max().getAsInt() + 1;
    }
}

