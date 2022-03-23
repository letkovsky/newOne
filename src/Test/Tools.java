package Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Tools {
    private static Scanner s = new Scanner(System.in);

    public static void Writer(String message) {
        System.out.println(message);
    }

    public static int readInt() {
        return s.nextInt();
    }

    public static double readDouble() {
        return s.nextDouble();
    }

}
