package Digits;

public class CoinChange {
    public static int count(int[] coins, int number, int target)
    {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || number< 0) {
            return 0;
        }
        int first= count(coins, number, target - coins[number]);
        int second= count(coins, number - 1, target);
        return first + second;
    }

    public static void main(String[] args)
    {
        int[] coinArray = { 1,2,3,4,5 };
        int target = 16;
        System.out.print("The total number of ways to get the desired change is "
                + count(coinArray, coinArray.length - 1, target));
    }



}
