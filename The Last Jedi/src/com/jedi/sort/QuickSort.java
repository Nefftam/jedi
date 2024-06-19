package com.jedi.sort;

import java.util.Arrays;
import java.util.ArrayDeque;

public class QuickSort implements ISortProvider {
    @Override
    public void sort(int[] a) {
        //qSortRecursive(a, 0 , a.length-1);
        System.out.println("Input : " + Arrays.toString(a));
        qSortIterative(a, 0 , a.length-1);

    }

    private static void qSortRecursive(int a[], int startIndex , int endIndex)
    {
        if(startIndex < endIndex)
        {
            int pIndex = partition(a,startIndex,endIndex);
            System.out.println(Arrays.toString(a));
            qSortRecursive(a,startIndex,pIndex-1);
            qSortRecursive(a,pIndex+1,endIndex);
        }
    }

    private static void qSortIterative(int a[], int startIndex , int endIndex)
    {
        ArrayDeque stack = new ArrayDeque();
        stack.push(startIndex);
        stack.push(endIndex);
        while(!stack.isEmpty())
        {
            endIndex = (int)stack.pop();
            startIndex = (int)stack.pop();
            int pIndex = partition(a,startIndex,endIndex);
            if(pIndex-1 > startIndex)
            {
                stack.push(startIndex);
                stack.push(pIndex-1);
            }
            if (pIndex+1 < endIndex)
            {
                stack.push(pIndex+1);
                stack.push(endIndex);
            }
            System.out.println("start: " + startIndex + "  end: " + endIndex + " " + Arrays.toString(a));
        }
    }

    /**
     *  <b>
     *  on left of pivot will have all smaller and on right will have all greater values
     *  </b>
        return correct position of pivot[lastIndex is pivot initially]
        also puts the pivot in correct place
     */
    private static int partition(int a[], int startIndex , int endIndex)
    {
        int pivot = endIndex;
        int pIndex = startIndex;
        for(int i = startIndex ; i < endIndex ; i++)
        {
            if(a[i] < a[pivot])
            {
                int temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[pIndex];
        a[pIndex] = temp;


        return pIndex;
    }
}