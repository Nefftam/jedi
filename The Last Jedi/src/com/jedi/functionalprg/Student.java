package com.jedi.functionalprg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student {
    String name;
    int roll;
    int marks;

    public Student(String name , int roll , int marks)
    {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + roll + ", " + marks + "]";
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("shahzad", 1 , 97));
        students.add(new Student("shireen", 2 , 98));
        students.add(new Student("shadab", 3 , 99));
        students.add(new Student("shafa", 4 , 100));

        students.stream().filter((Student s) -> {
            if(s.marks >=98)
                return true;
            else
                return false;
        }).forEach((Student s) -> System.out.println(s));


        Comparator<Student> comparator = (s1,s2) -> s1.marks - s2.marks ;
    }
}
