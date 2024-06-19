package com.jedi.sort;

public class SortFactory {
    public static ISortProvider getSortType(SortType sortType)
    {
        switch (sortType)
        {
            case Bubble: return new BubbleSort();

            case Selection: return new SelectionSort();

            case Insertion: return new InsertionSort();

            case Quick: return new QuickSort();

            case Merge: return new MergeSort();
        }
        return null;
    }
}
