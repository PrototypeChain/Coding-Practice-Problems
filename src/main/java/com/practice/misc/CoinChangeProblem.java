package com.practice.misc;

public class CoinChangeProblem {

    private static int[] coins = {1,2,4};

    public static void main(String[] args) {
        System.out.println(count(3, 0));
    }

    public static int count(int n, int startCoin)
    {
        // If n is 0 then there is 1 solution
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        int nCoins = 0;

        for(int coin=startCoin; coin<coins.length; coin++)
        {
            nCoins += count(n-coins[coin], coin);
        }

        return nCoins;
    }

}
