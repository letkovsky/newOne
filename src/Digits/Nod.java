package Digits;

public class Nod {
    public static int findMaxNod(int a, int b){
        while (a != 0 && b != 0){

            if (a > b){
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a + b;
    }

    public static int findMaxNod2(int a, int b){
        if(a == 0) return b;
        if (b == 0) return a;
        return a > b ? findMaxNod2(a%b,b): findMaxNod2(a, b%a);

    }

    public static void main(String[] args) {
        System.out.println(findMaxNod(30, 28));
        System.out.println(findMaxNod2(30, 28));
    }
}
