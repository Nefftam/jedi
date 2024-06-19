package com.jedi.shafa.code;

import javax.servlet.ServletInputStream;
import java.io.*;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class Reading {
    public static void main(String[] args) throws IOException {

        //Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        //System.out.println("path of . = " + path);
        String filePath = "src/com/jedi/shafa/code/mytext.txt";
        InputStream is = new FileInputStream(new File(filePath));
        int x;
        while ((x = is.read()) != -1)
        {
            char ch = (char)x;
            System.out.println(ch);
        }
        is.close();
    }

}
