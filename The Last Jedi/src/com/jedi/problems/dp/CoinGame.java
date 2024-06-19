package com.jedi.problems.dp;


//Player 1 picks one from any two ends
//Player 2 picks after player from any two ends
//Player 1 should maximize his amount

public class CoinGame {
    public static int count =0;
    private static int a[] = {4,100,5,10};
    private static int dp[][] = new int[a.length][a.length];
    public static void main(String[] args) {
        System.out.println(coins(0,a.length-1));

        //System.out.println(coinsDP(0,a.length-1));
        //System.out.println(count);
    }

    public static int coins(int i, int j)
    {
        count++;
        if(i > j) return 0;
        if(i < 0 || j <0) return Integer.MAX_VALUE-1;

        return Math.max(a[i] + Math.min(coins(i+1,j-1),coins(i+2,j)) ,
                a[j] + Math.min(coins(i+1,j-1),coins(i,j-2)));
    }

    private static int coinsDP(int i , int j)
    {
        count++;
        if(i > j) return 0;
        if(i < 0 || j <0) return Integer.MAX_VALUE-1;

        if(dp[i][j] != 0 ) return dp[i][j];

        dp[i][j] = Math.max(a[i] + Math.min(coinsDP(i+1,j-1),coinsDP(i+2,j)) ,
                a[j] + Math.min(coinsDP(i+1,j-1),coinsDP(i,j-2)));

        return dp[i][j];
    }
}
