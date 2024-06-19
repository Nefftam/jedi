package com.jedi.berry;

public class Rough1 {
    static int p=10,q=11;
    public static void main(String[] args) {
        String s = new String("light");
        s.intern();
        Character A = new Character('A');
        Character a = new Character('a');
        Character zero = new Character('0');
        System.out.println("A = " + (int)A + "\na = " + (int)a + "\nzero = " + (int)zero);
        Character.isLetterOrDigit(zero);
        System.out.println(p);
        System.out.println(q);
    }
}
