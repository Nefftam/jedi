// Checkchanges.java - (insert one line description here)
// (C) Copyright 2018 Hewlett Packard Enterprise Development LP

package com.jedi.testcode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Checkchanges
{

    /**
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(final String[] args)
            throws FileNotFoundException,
            IOException,
            Exception
    {
        Integer a[] = {1,2};
        List<Integer> al = Arrays.asList(a);

        final String ver = "4.20";
        byte b[] = new byte[4];
        b = ver.getBytes();
        final String encryptedFile = "C:\\Users\\hassansh\\Desktop\\ovsupp\\encryptdecryptstory\\Decryption4.1\\Decryption4.1\\New_DecryptionUtility3.0"
                + "\\ai-cicvc3-215.vse.rdlabs.hpecorp.net-CI-2017_12_14-07_04_14.870653.sdmp";
        try (FileOutputStream os = new FileOutputStream(encryptedFile, true))
        {
            System.out.println("Going to write version in crypted file");
            os.write(b);
        }
        /*final String param[] = {encryptedFile
                };
        DecryptionUtil.main(param);*/
    }



}