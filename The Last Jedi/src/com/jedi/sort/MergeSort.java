package com.jedi.sort;

import java.util.Arrays;

public class MergeSort implements ISortProvider {

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int a[] = {2,14,12,3,17,1,4,13};
        m.sort(a);
    }
    @Override
    public void sort(int[] a) {
        //mergeSortRecursive(a,0,a.length-1);
        mergeSortIterative(a);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSortRecursive(int a[] , int startIndex, int endIndex)
    {
        if (startIndex < endIndex)
        {
            int mid = (startIndex+endIndex)/2;
            mergeSortRecursive(a,startIndex,mid);
            mergeSortRecursive(a,mid+1,endIndex);
            merge(a,startIndex,mid,endIndex);
        }
    }

    private static void mergeSortIterative(int a[])
    {
        for(int currsize = 1; currsize < a.length ; currsize= currsize*2 )
        {
            for(int start = 0; start < a.length-1 ; start= start+2*currsize)
            {
                int mid = currsize + start -1;
                int end = Math.min(2*currsize + start-1,a.length-1);
                merge(a, start, mid, end);
            }
        }
    }
    private static void merge(int a[], int startIndex , int mid , int endIndex)
    {
        int la[] = new int[mid - startIndex + 1];
        int ra[] = new int[endIndex-mid];

        int i = 0;
        int j = 0;

        while(i < la.length)
        {
            la[i] = a[startIndex + i];
            i++;
        }
        while(j < ra.length)
        {
            ra[j] = a[mid + 1 + j];
            j++;
        }

        i=j=0;
        int k = startIndex;
        //int p=1,q = 1;
        //System.out.println("p is " + p + " q is " + q);
        while (i < la.length && j < ra.length)
        {
            if(la[i] < ra[j])
                a[k++] = la[i++];
            else
                a[k++] = ra[j++];
        }

        while(i < la.length)
            a[k++] = la[i++];
        while(j < ra.length)
            a[k++] = ra[j++];
    }
}
