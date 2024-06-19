package com.jedi.problems.dp;

import java.util.Arrays;

public class SubsetSum {
    static int a[] = {6,4,2,1,1,12,6,9};
    public static int sum;
    static Boolean dp[][] ;
    static int steps = 0;
    public static void main(String[] args) {
        sum =110 ;
        dp = new Boolean[a.length][sum+1];

        System.out.println(isSubsetSum(a.length -1 ,sum));
        System.out.println(steps);
        steps = 0;
        //printArray(dp);
        System.out.println(isSubsetSumDP(a.length-1,sum));
        System.out.println(steps);
        steps = 0;
        //printArray(dp);
        //printElements(dp);

    }

    /**
     *
     * Recursive situation : for each index , is there a subset if we include this
     *                       in sum Or, is there a subset if we exclude this index in sum
     * @param n :  last index of array
     * @param sum :
     * @return true if there is a subset with sum = sum
     */
    private static boolean isSubsetSum(int n , int sum)
    {
        steps ++;
        if(sum == 0) return true;
        if(n < 0 || sum < 0) return false;

        return isSubsetSum(n-1,sum-a[n]) || isSubsetSum(n-1,sum);
    }

    /**
     * dp i,j is true if dp(i-1)(j) is true or dp(i-1)(j-a[i]) is true
     * dp(i-1)(j) : represents if i was not included but sum j could be formed
     * from excluding i
     * dp(i-1)(j-a[i]) : represents if i was included and sum j-a[i] could be formed
     * @param n
     * @param sum
     * @return
     */
    private static boolean isSubsetSumDP(int n , int sum)
    {
        steps++;

        if(sum == 0) return true;

        if(n < 0 || sum < 0) return false;

        if(dp[n][sum] != null) return dp[n][sum];

        dp[n][sum] =  isSubsetSumDP(n-1,sum-a[n]) || isSubsetSumDP(n-1,sum);

        return dp[n][sum];
    }

    private static void printArray(Boolean dp[][])
    {
        for (Boolean x[] : dp)
            System.out.println(Arrays.toString(x));
    }
    private static void printElements(Boolean dp[][])
    {
        for(int i = a.length-1 , j = sum ; (i >= 0 && j >= 0) ;)
        {
            //System.out.println("i = " + i + "  j =  " + j);
            if(dp[i][j] !=null && dp[i][j])
            {
                if(i > 0 && j > 0 && dp[i-1][j] != null && dp[i-1][j])
                {
                    i = i-1 ;
                }
                else
                {
                    System.out.println(a[i]);
                    j = j-a[i];
                    i = i -1;
                }
            }
            else
                break;
        }
    }
}
