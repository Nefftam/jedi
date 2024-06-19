package com.jedi.berry;

import java.util.ArrayList;
import java.util.Set;

public class checkInstanceof {
    public static void main(String[] args) {
        C c = new C();

        if(c instanceof A)
        {
            System.out.println("new C is instanceofA");
        }
        else
            System.out.println("new c is not instance of A");
        String s = new String();
        int a[] = new int[10];
        ArrayList arrayList = null;
    }
}


class A {}

class B extends A{}

class C extends B {}