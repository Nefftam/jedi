package com.jedi.problems.dp;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LongestCommonSubSequence {
    static String s1 = "acbcf";
    static String s2 = "abcdaf";
    static int dp[][] = new int[s1.length()][s2.length()];

    public static void main(String[] args) {

        System.out.println(lcsDP(s1.length()-1,s2.length()-1));
        printArray(dp);
    }

    static int lcs(int i, int j)
    {
        if(i < 0 || j < 0) return 0;

        if(s1.charAt(i)== s2.charAt(j))
            return 1+ lcs(i-1,j-1);
        else
            return Math.max(lcs(i-1,j),lcs(i,j-1));

    }

    static int lcsDP(int i , int j)
    {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] !=0 ) return dp[i][j];

        if(s1.charAt(i)== s2.charAt(j))
            dp[i][j] =  1+ lcsDP(i-1,j-1);
        else
            dp[i][j] = Math.max(lcsDP(i-1,j),lcsDP(i,j-1));

        return dp[i][j];
    }

    private static void printArray(int dp[][])
    {
        for (int x[] : dp)
            System.out.println(Arrays.toString(x));
    }
}
