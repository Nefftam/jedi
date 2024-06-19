package com.jedi.functionalprg;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        String str = "s";

        MyInterface m = Utility::strToInt;

        MyInterface m1 = (String str1)-> Integer.parseInt(str1);

        System.out.println(m1.stringToInt("110"));

        List<Integer> myList = new ArrayList<>();

        myList.add(10);
        myList.add(20);
        myList.add(45);

        myList.forEach((a) -> System.out.println(a));


    }
}
