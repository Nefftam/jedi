package com.jedi.practise;

import java.util.*;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Pair> map = new HashMap<>();
        for(int key : nums)
        {
            Pair c = map.getOrDefault(key,new Pair(key,0));
            c.count = c.count +1;
            map.put(key,c);
        }
        TreeMap<Pair,Integer> treeMap = new TreeMap<>((a,b)-> {
            int res = a.count - b.count;
            return res==0?1:res*-1;
            //return -1 * res;        // in this case when count are equal, treemap merges all to 1 entry(smallest)
        });
        for(Pair c: map.values())
        {
            System.out.println(c);
            treeMap.put(c, c.val);
        }
        System.out.println("---------------");
        for(Pair c : treeMap.keySet())
        {
            System.out.println(c);
        }

        List<Integer> res = new ArrayList<>();

        for(Pair c : treeMap.keySet())
        {
            if(k > 0)
                res.add(c.val);
            else
                break;
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {6,3,4};//,2,2,5,5,1,2};
        topKFrequent(nums, 2);
        //System.out.println(topKFrequent(nums, 2));
    }
}

class Pair{
    int val;
    int count;
    Pair(int a , int b)
    {
        val = a;
        count = b;
    }

    @Override
    public boolean equals(Object obj) {
        Pair obj1 = (Pair)obj;
        return this.val == obj1.val;
    }

    @Override
    public String toString() {
        return val + " : " +  count;
    }
}
