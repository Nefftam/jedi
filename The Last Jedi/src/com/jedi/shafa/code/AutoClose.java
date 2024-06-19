package com.jedi.shafa.code;

import java.io.*;

public class AutoClose {
    public static void main(String[] args) throws IOException {

        try(
                BufferedReader bfr = new BufferedReader
                (new InputStreamReader(new FileInputStream
                        (new File("src/com/jedi/shafa/code/mytext.txt"))));

                InputStream is = new FileInputStream(new File("src/com/jedi/shafa/code/abc.txt"))
           )
        {

            String str;
            while ((str = bfr.readLine()) != null)
            {
                System.out.println(str);
            }
            System.out.println("---------------------------------");
            int x ;
            while ((x = is.read()) != -1){
                System.out.println((char)x);
            }
            System.out.println("I am done");

        }
    }
}
