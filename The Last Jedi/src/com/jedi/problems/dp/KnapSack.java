package com.jedi.problems.dp;

public class KnapSack {

    static int price[] = {60,100,120};
    static int wt[] = {10,20,30};
    public static void main(String[] args) {
        int capacity = 50;
        System.out.println(maximizeSackValue(price.length-1,capacity));
    }

    static int maximizeSackValue(int n , int weight)
    {
        if(weight == 0) return 0;

        if(n <0 || weight < 0) return Integer.MIN_VALUE;

        return Math.max(price[n] + maximizeSackValue(n, weight-wt[n]),
                maximizeSackValue(n-1,weight));
    }
}
