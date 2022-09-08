package Digits;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanToInteger {

    Map<Character, Integer> map = new HashMap<>();

    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

    }

    public int convertToInt(String s) {
        int result = 0;
        int previous = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = map.get(s.charAt(i));
            if (current < previous) {
                result -= current;
            } else {
                result += current;
            }
            previous = current;
        }

        return result;
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        {
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsValue(chars[i])) {
                stack.push(chars[i]); // open
            } else if (map.containsKey(chars[i])) { // close
                if (stack.isEmpty() || stack.pop() != map.get(chars[i])) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "(({}[()]))";
        System.out.println(isValid(s));


        String str = "3[a2[c]]";
        int count = 0;
        String result = "";

        Stack<Integer> repeatCount = new Stack<>();
        Stack<String> strings = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                count = 10 * count + Integer.parseInt(Character.toString(str.charAt(i)));
            } else if (str.charAt(i) == '[') {
                repeatCount.push(count);
                count = 0;
                strings.push(result);
                result = "";

            } else if (str.charAt(i) == ']') {
                StringBuilder stringBuilder = new StringBuilder(strings.pop());
                int idx = repeatCount.pop();
                for ( int j = 0; j < idx; j++){
                    stringBuilder.append(result);
                }
                result = stringBuilder.toString();
            } else {
                result += str.charAt(i);
            }
        }
        System.out.println(strings);
        System.out.println(repeatCount);
        System.out.println(result);




    }
}
