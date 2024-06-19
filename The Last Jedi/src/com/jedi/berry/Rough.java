package com.jedi.berry;

import java.io.FileReader;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

public class Rough {
    public static void main(String[] args) {
        int arr[] = new int[2];
        arr[0] = 5;
        arr[1] = 1;
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        arr = Arrays.copyOf(arr, 5);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        int b[] = new int[5];
        System.arraycopy(arr,0,b,0, 5);
        System.out.println(Arrays.toString(b));
    }
}
