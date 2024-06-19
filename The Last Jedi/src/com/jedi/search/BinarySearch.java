package com.jedi.search;


import java.util.Arrays;

public class BinarySearch implements ISearchProvider {

    @Override
    public int search(int[] a, int key , int start , int end) {
        while(start <= end)
        {
            int mid = (start + end)/2;
            if(a[mid] == key)
                return mid;
            else if(key < a[mid])
                end = mid -1;
            else
                start = mid +1;
        }
        System.out.println();;
        return -1;
    }
}
