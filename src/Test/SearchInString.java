package Test;

import java.util.*;

public class SearchInString {

    public static void main(String[] args) {
        String x = "B";
        String y = "BCVVVVVVBBB";
        HashSet<Integer> set = new HashSet<>();
        System.out.println(searchRepeat(x, y));


        String ss = "lBBbnlkBBB";
        String pat = "B";
        int indPat;
        int curInd = 0;


        int counter = 0;
        while ((indPat = ss.indexOf(pat,curInd)) != -1) {

            if (indPat == curInd){
                counter++;
                set.add(counter);
            }else {
                counter = 0;
            }

            curInd = indPat + 1;
        }
        System.out.println(set);
        int asInt = set.stream().mapToInt(v -> v).max().getAsInt();
        System.out.printf("%s - %d", pat, asInt +1);

    }


    public static int searchRepeat(String little, String big) {

//        HashMap<String,Integer> map = new HashMap<>();
//
//        String abc = big.replaceAll(little, "1");// заменяем подстроку little на 1
//        String[] split = abc.split("");
//
//        String previous = " ";
//        for (int i = 0; i < split.length; i++) {
//            if (split[i].equals(previous)) {
//                map.put(previous,map.get(previous) + 1);
//            }else if (!map.containsKey(split[i])){
//                map.put(split[i], 1);
//            }
//            previous = split[i];
//        }
//        System.out.println(map);
//        System.out.println();
//
//        return map.get("1");
        HashSet<Integer> set = new HashSet<>();
        String s = big.replaceAll(little, "0");
        char[] chars = s.toCharArray();
        char previous = ' ';
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != previous){
                count = 0;
            }
            if (chars[i] == previous & previous == '0'){
                count++;
                set.add(count);

            }
            previous = chars[i];
        }
        System.out.println(set);
        return set.stream().mapToInt(v -> v).max().getAsInt() + 1;
    }
}
