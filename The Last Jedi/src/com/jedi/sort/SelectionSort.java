package com.jedi.sort;

import java.util.Arrays;

public class SelectionSort implements ISortProvider {
    @Override
    public void sort(int[] a) {
        for(int i = 0 ; i < a.length-1 ; i++)
        {
            int minIndex = i;
            for(int j = i+1 ; j < a.length ; j++)
            {
                if(a[j] < a[minIndex])
                    minIndex = j;
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
            System.out.println("After iteration " + i + " : " + Arrays.toString(a));
        }
    }
}
