package com.jedi.problems.dp;

public class MinimumJumpToEnd {

    private static int a[];
    public static int minJump(int ar[])
    {
        a = ar;
        return minJump();
    }
    private static int minJump()
    {
        if(a[0] == 0) throw new IllegalArgumentException();
        int i = 0;
        int count = 0;
        System.out.print(i + ":" + a[i] + " ");

        while(i+a[i] < a.length)
        {
            int maxValueIndex = findMax(i,i+a[i]);
            if(maxValueIndex < a.length -1)
            {
                count++;
                System.out.print(maxValueIndex + ":" + a[maxValueIndex] + " ");
            }
            i = i + a[i];
        }
        System.out.println();
        return count + 1;
    }

    private static int findMax(int i, int j)
    {
        int max = i;
        for(i = i+1 ;(i <= j && i < a.length);i++)
        {
            if(a[i] + i > a[max] + max)
            {
                max =  i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int ar[] = {1,5,3,18,10,12,14,12,10,16};
        System.out.println(minJump(ar));
    }
}
