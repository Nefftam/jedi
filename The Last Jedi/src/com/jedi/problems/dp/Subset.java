package com.jedi.problems.dp;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Subset {
    private static List<Integer> list = new LinkedList<>();
    private static int a[] ;

    public static void printSubsets(int ar[])
    {
        a = ar;
        printSubsets(ar.length-1);
    }
    /**
     *
     * @param n is last index of array
     */
    private static void printSubsets(int n)
    {
        if(n < 0) {
            System.out.println(list);
            return;
        }

        list.add(a[n]);
        printSubsets(n-1);

        list.remove(list.size()-1);
        printSubsets(n-1);

    }

    public static void main(String[] args) {
        int a[] = {-11,2,3};
        Subset.printSubsets(a);
    }
}
