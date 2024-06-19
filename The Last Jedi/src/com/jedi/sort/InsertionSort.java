package com.jedi.sort;

import java.util.Arrays;

public class InsertionSort implements ISortProvider {
    @Override
    public void sort(int[] a) {
        for (int i = 1 ; i < a.length ; i++)
        {
            for (int j = i ; (j > 0 && a[j] < a[j-1]); j--)
            {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
            System.out.println("After iteration " + i + " : " + Arrays.toString(a));
        }
    }
}
