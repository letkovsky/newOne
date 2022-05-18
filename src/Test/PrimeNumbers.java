package Test;

import java.util.Map;

public class PrimeNumbers {

    // is a num prime ( является ли число простым)

    public static boolean isPrime(int num){
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
