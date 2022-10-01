package com.example.demo.atcoder.abc268;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i],i);
        }
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            int c =  i- map.get(i);
            if(c<0){
                c+=n;
            }
        }
    }
}
