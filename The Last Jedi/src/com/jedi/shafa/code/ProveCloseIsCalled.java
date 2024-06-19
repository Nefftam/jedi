package com.jedi.shafa.code;

import java.io.*;

public class ProveCloseIsCalled {

    public static void main(String[] args) throws IOException {
        try(
                BufferedReader bfr = new MyBufferedReader((new InputStreamReader(new FileInputStream
                        (new File("src/com/jedi/shafa/code/mytext.txt")))));
           )
        {

            String str;
            while ((str = bfr.readLine()) != null)
            {
                System.out.println(str);
            }
            System.out.println("---------------------------------");
            System.out.println("I am done");

        }
    }
}
