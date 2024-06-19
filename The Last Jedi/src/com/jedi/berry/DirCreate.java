package com.jedi.berry;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.Date;

public class DirCreate {
    String path;
    public static void main(String[] args) {
        File file = new File("c:\\hello\\hello1\\hello2");

        boolean dirCreated = file.mkdir();
        System.out.println(dirCreated);

        System.out.println(new Date(123456789).toString());

    }

    @Override
    public boolean equals(Object obj) {
        DirCreate dir = (DirCreate)obj;
        return this.path.equals(dir.path);
    }
}
