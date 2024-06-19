package com.jedi.shafa.code;

import java.io.*;

public class ReadFromFile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader
                    (new FileInputStream(new File("src/com/jedi/shafa/code/mytext.txt"))));
            String str;
            while( (str = br.readLine())!= null){
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
