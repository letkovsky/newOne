package Test;

import java.util.*;

public class SearchInString {

    public static void main(String[] args) {
        String x = "B";
        String y = "BBBCBBB";
        System.out.println(searchRepeat(x, y));

    }


    public static int searchRepeat(String little, String big) {

        HashMap<String,Integer> map = new HashMap<>();

        String abc = big.replaceAll(little, "1");// заменяем подстроку little на 1
        String[] split = abc.split("");

        String previous = " ";
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(previous)) {
                map.put(previous,map.get(previous) + 1);
            }else if (!map.containsKey(split[i])){
                map.put(split[i], 1);
            }
            previous = split[i];
        }
        System.out.println(map);
        System.out.println();

        return map.get("1");
    }
}
