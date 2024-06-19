package com.jedi.problems.dp;

public class Fibonacci {

    int dp[] ;
    static int count = 0;
    public Fibonacci(int size)
    {
        dp = new int[size+1];
    }

    int fibDp(int n)
    {
        count++;
        if(n < 2 ) return 1;

        if(dp[n] != 0 ) return dp[n];

        dp[n] = fibDp(n-1) + fibDp(n-2);

        return dp[n];

    }


    int fibR(int n)
    {
        count++;
        if (n < 2) return 1;

        return fibR(n-1) + fibR(n-2);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci(10);
        f.fibR(10);
        System.out.println(count);
        count= 0;
        f.fibDp(10);
        System.out.println(count);
    }
}
