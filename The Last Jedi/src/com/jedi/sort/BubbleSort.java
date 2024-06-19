package com.jedi.sort;

import java.util.Arrays;

public class BubbleSort implements ISortProvider{

    @Override
    public void sort(int[] a) {
        for(int i = a.length -1 ; i > 0 ; i--)      //fixing the lastIndex, secondLast and so on....
        {
            for(int j = 0 ; j < i ; j++)
            {
                if(a[j] > a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            System.out.println("After iteration " + (a.length - i) + " : " + Arrays.toString(a));
        }
    }
}
