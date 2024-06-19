package com.jedi.testcode;
import com.jedi.problems.dp.Subset;
import com.jedi.search.*;
import com.jedi.sort.*;
import com.jedi.list.*;

public class JediNeedsNoTest {

    public static void main(String[] args) {
        //testSearch();
        //testSort();
        //testlinkedlist();
        testPrintSubset();

    }
    private static void testSearch()
    {
        ISearchProvider spl = new LinearSearch();
        int a[] = {3,12,4,1,2};
        System.out.println(spl.search(a,2,0 ,a.length-1));
        int sortedarray[] = {5,13,23,41,90};
        ISearchProvider spb = new BinarySearch();
        System.out.println(spb.search(sortedarray,13,0 ,a.length-1));
    }
    private static void testSort()
    {
        //int a[] = {50,9,13,1,2};
        int a[] = {15,41,13,120,1};
        ISortProvider bubblesort = SortFactory.getSortType(SortType.Bubble);
        ISortProvider selectionsort = SortFactory.getSortType(SortType.Selection);
        ISortProvider insertionsort = SortFactory.getSortType(SortType.Insertion);
        ISortProvider quicksort = SortFactory.getSortType(SortType.Quick);
        ISortProvider mergesort = SortFactory.getSortType(SortType.Merge);
        //bubblesort.sort(a);
        //selectionsort.sort(a);
        //insertionsort.sort(a);
        //quicksort.sort(a);
        mergesort.sort(a);
    }

    private static void testlinkedlist()
    {
        JediLinkedList list = new JediLinkedList();
        list.add(10);
        list.add(20);
        list.add(12);
        list.add(22);
        System.out.println(list);
        list.reverseListRecursive();
        System.out.println(list);
        System.out.println(list.length());
    }

    private static void testPrintSubset()
    {
        int a[] = {-11,2,3};
        Subset.printSubsets(a);
    }
}
