package com.jedi.enums;

import java.util.Calendar;

public class EnumTest {
    public static void main(String[] args) {

        System.out.println(Color.valueOf("BLUE"));   // the string valueOf takes is case-sensitive
        EnumTest eTest = new EnumTest();
        System.out.println(Calendar.DAY_OF_WEEK);
    }

    void func()
    {}
}
