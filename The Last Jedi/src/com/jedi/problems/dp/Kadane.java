package com.jedi.problems.dp;

import java.util.Map;

//Longest Contiguous sub-array Sum
public class Kadane {

    static int nums[] = {1,2,-4,5,10,11,-2,10,-2};
    public static void main(String[] args) {
        System.out.println(maxsum());
    }
    static int maxsum()
    {
        int localSum=0;
        int ans = nums[0];
        for(int i = 0; i<nums.length; i++)
        {
            localSum = Math.max(nums[i], localSum+nums[i]);
            ans = Math.max(localSum,ans);
        }
        return ans;
    }
}
