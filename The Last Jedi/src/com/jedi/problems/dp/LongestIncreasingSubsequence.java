package com.jedi.problems.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int a[] = {12,3,5,2,6,8,1};

    public static void main(String[] args) {
        System.out.println(lic());
    }

    //Each index of dp represents what is longest increasing count till here
    //For each index it will be 1 + (max of the value of dp index which are lower in value than
    //current number)
    private static int lic()
    {
        int dp[] = new int[a.length];

        for(int i = 0 ; i < a.length ; i++)
            dp[i] = 1;

        int max = 0;
        for(int i = 1 ; i < a.length ; i++)
        {
            for(int j = i-1 ; j >= 0 ; j--)
            {
                System.out.println(a[j] + " " + a[i]);
                if(a[j] < a[i])
                {
                    System.out.println(dp[j] + "  : " + dp[i]);
                    if(dp[j] >= dp[i])
                    {
                        dp[i] = dp[j] + 1;
                        if(dp[i] > dp[max])
                            max = i;
                    }

                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[max];
    }
}
