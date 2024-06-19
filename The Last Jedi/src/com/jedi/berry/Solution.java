package com.jedi.berry;

import java.util.regex.*;
import java.util.*;
public class Solution {

    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        System.out.println("bye");
        Pattern multipleLineComment = Pattern.compile("((?s)\\/\\*.*?\\*\\/|(?-s)\\/\\/.*)");

        StringBuilder input = new StringBuilder();
        while (sc.hasNextLine()){
            input.append(sc.nextLine().trim());
            input.append("\n");
        }
        Matcher m1 = multipleLineComment.matcher(input.toString());
        while (m1.find())
            System.out.println(m1.group(1));
    }
}