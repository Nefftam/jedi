package com.jedi.shafa.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadFromKeyboard {

    public static void main(String[] args) throws IOException {

        Reader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String str;
        while( (str = br.readLine())!= null){
            System.out.println(str);
        }
        br.close();
    }
}
