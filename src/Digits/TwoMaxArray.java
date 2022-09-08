package Digits;

public class TwoMaxArray {
    public static int findSecondMax(int[] arr) {
        int max = arr[0]; // max
        int temp = arr[0]; // second max
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                temp = max;
                max = arr[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,4,5,8,4,56,34,23,77};
        System.out.println(findSecondMax(ints));
        System.out.println();

        String s = "Hello";
        String hello = new String("Hello");
        String hello1 = new String("Hello");

        System.out.println(hello.equals(hello1));
    }

}
