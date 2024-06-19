package com.jedi.iterating;

import java.util.*;

public class Iterating {
    public static void main(String[] args) {
        HashMap<String,String> check = new HashMap<>();
        check.put("a", "aa");
        check.put("b", "bb");

        for(Map.Entry<String,String> entry : check.entrySet())
        {
            entry.getKey();
            entry.getValue();
        }

        String s = check.getOrDefault("c", "cc");
        check.put("c", s + "kk");

        for(String s1 : check.keySet())
        {

        }
        for(String s2 : check.values())
        {

        }

        ArrayList<Integer> aList = new ArrayList<>();
        aList.add(1);
        for(int i = 0 ; i< aList.size(); i++)
        {
            System.out.println(aList.get(i));
        }

        for(int x : aList)
        {}

        Iterator<Integer> it = aList.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

        Stack<Integer> stack = new Stack<>();
        while (!stack.isEmpty())
        {
            int x = stack.pop();
        }

    }
}
