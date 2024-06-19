package com.jedi.shafa.code;

import java.util.HashMap;
import java.util.Map;

public class FindMissingNumber {
    public static void main(String[] args) {
        FindMissingNumber findMissingNumber = new FindMissingNumber();
        int[] a = {2,4,1,5};
        System.out.println("missing number : "+findMissingNumber.findMissing_3(a,5));
    }


    private int findMissing_1(int a[],int n) {
        int sum = n*(n+1)/2;
        int arraySum=0;

        for(int i=0;i<a.length;++i) {
            arraySum+=a[i];
        }
        return (sum-arraySum);
    }

    private int findMissing_2(int a[], int n){
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<a.length;++i) {
            map.put(a[i],true);
        }
        for(int i=1;i<=n;++i){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return 0;
    }

    private int findMissing_3(int a[], int n) {
        int num=0;
        for (int j=0, i=1; i<=n && j<a.length; ++j,++i) {
            num=num^a[j]^i;
        }
        return num^n;
    }

    private int findMissingUsingXOR(int input[], int n){

        int result = 0;
        for (int i = 0; i < input.length ; i++){
            result = result ^ input[i] ^ i+1;
        }
        result = result ^ n;
        return result ;
    }

}
