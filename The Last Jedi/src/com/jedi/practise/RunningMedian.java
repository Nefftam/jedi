package com.jedi.practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        RunningMedian rm = new RunningMedian();
        double res[] = rm.getMedian(a);
        System.out.println(Arrays.toString(res));
    }

    public double[] getMedian(int arr[])
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> -a*a.compareTo(b)); //Or use Collections.reverseOrder() as Comparator

        double median[] = new double[arr.length];
        for(int i = 0 ; i < arr.length ; i++)
        {
            int num = arr[i];
            add(num,minHeap,maxHeap);
            rebalance(minHeap,maxHeap);
            median[i] = getithMedian(minHeap,maxHeap);
        }
        return median;
    }

    private double getithMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        PriorityQueue<Integer> biggerHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
        PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;

        System.out.println("minHeap = " + minHeap);
        System.out.println("maxHeap = " + maxHeap);
        if(biggerHeap.size() == smallerHeap.size())
        {
            return ((double)biggerHeap.peek() + smallerHeap.peek())/2;
        }
        else
        {
            return biggerHeap.peek();
        }
    }

    //In a sorted list lower half will be kept in maxHeap and upper half should be kept in minHeap
    //median = max from left(hence maxHeap) + min from right(hence minHeap)
    //
    private void add(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if(maxHeap.size() == 0 || num > maxHeap.peek())
            minHeap.add(num);
        else
            maxHeap.add(num);

        System.out.println(" add minHeap = " + minHeap);
        System.out.println(" add maxHeap = " + maxHeap);
    }

    private void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        PriorityQueue<Integer> biggerHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
        PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;

        if(biggerHeap.size() - smallerHeap.size() >=2)
        {
            smallerHeap.add(biggerHeap.poll());
        }
    }
}
