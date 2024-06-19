package com.jedi.search;

public class LinearSearch implements ISearchProvider{

    @Override
    public int search(int[] a , int key , int start , int end) {
        for(int i = start ; i <= end ; i++)
            if(a[i] == key)
                return i;
        return -1;
    }
}
