package com.jedi.practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    static int arr[][] = {{3,6,18},{16,19,24,28},{2,4,9}};
    static int totalElements = 0;
    public static void main(String[] args) {

        System.out.println((Arrays.toString(merge(arr))));

    }

    public static int[] merge(int arr[][])
    {
        PriorityQueue<QueueNode> minHeap = new PriorityQueue<>();
        addFirstKElement(arr,minHeap);
        int result[] = new int[totalElements];

        for(int i = 0; i < totalElements ; i++)
        {
            QueueNode curr = minHeap.poll();
            result[i] = curr.value;
            int newIndex = curr.index + 1;

            if(newIndex < arr[curr.arrayNo].length)
            {
                minHeap.add(new QueueNode(curr.arrayNo, newIndex, arr[curr.arrayNo][newIndex]));
            }
        }
        return result;
    }

    private static void addFirstKElement(int[][] arr, PriorityQueue<QueueNode> minHeap) {
        for(int i = 0; i < arr.length ; i++)
        {
            totalElements += arr[i].length;
            minHeap.add(new QueueNode(i,0,arr[i][0]));
        }
    }
}

class QueueNode implements Comparable<QueueNode>
{
    int arrayNo;
    int index;
    int value;

    QueueNode(int arrayNo, int index, int value)
    {
        this.arrayNo = arrayNo;
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(QueueNode node) {
        return value - node.value;
    }
}
