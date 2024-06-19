package com.jedi.problems.dp;

/*
Given prices and length of Rod.
Divide the rod by length and sell such that total price after selling is maximized
 */
public class MaximumRodPrice {
    private static int a[] ={1,10,1,1,1,100,1,1};
    private static int length[] = {1,2,3,4,5,6,7,8};

    public static void main(String[] args) {
        System.out.println(maxPrice(a.length-1,a.length));
    }

    private static int maxPrice(int n,int sum)
    {
        System.out.println(n+1 + " " + sum);
        if(sum == 0) return 0;
        if(n < 0 || sum < 0) return Integer.MIN_VALUE;

        return Math.max(a[n] + maxPrice(n,sum-length[n]),
                maxPrice(n-1,sum));
    }

    private static int maxPrice2(int n,int sum)
    {
        //sSystem.out.println(n+1 + " " + sum);
        if(sum == 0) return 0;
        if(n < 0 || sum < 0) return Integer.MIN_VALUE;

        return Math.max(a[n] + maxPrice2(n,sum-(n+1)), maxPrice2(n-1,sum));
    }

    static int[][] dp = new int[a.length][a.length+1];

    private static int maxPriceDp(int n,int sum)
    {
        //sSystem.out.println(n+1 + " " + sum);
        if(sum == 0) return 0;
        if(n < 0 || sum < 0) return Integer.MIN_VALUE;
        if (dp[n][sum] != 0) return dp[n][sum];

        dp[n][sum] = Math.max(a[n] + maxPriceDp(n,sum-(n+1)), maxPriceDp(n-1,sum));
        return dp[n][sum];
    }


}
