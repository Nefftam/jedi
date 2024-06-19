package com.jedi.testcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckOne {
    public static void main(String[] args) {
        String a[] = {"one","two","three","four","five","six"};
        ArrayList<String> al = new ArrayList(Arrays.asList(a));
        System.out.println(al);
        //System.out.println(al.subList(1, 10));
        String str = "myvery";
        System.out.println(str.substring(5));
    }
}
