package com.jedi.problems.dp;

/**
 * given denominations , find the minimum number of coins to achieve an amount .
 */
public class MinimumDenominations {

    private static int denominations[] = {1,4,5};
    private static int amt = 9;
    public static void main(String[] args) {

        System.out.println(minCoins(denominations.length-1,amt));
    }


    private static int minCoins(int n , int amt)
    {
        if(amt == 0 ) return 0;
        if(n < 0 || amt < 0) return Integer.MAX_VALUE -1 ;

        return Math.min(1 + minCoins(n,amt-denominations[n]),minCoins(n-1,amt));
    }
}
