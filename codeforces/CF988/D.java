package com.example.demo.codeforces.CF988;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Long, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        long[] arr  = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], i);
        }
        boolean[] vis = new boolean[n];
        StringBuilder ans;
        List<Long> list = new ArrayList<>();
//        for (int i = 0; i <=33; i++) {
//            list.add()
//        }
        for (int i = 0; i < n; i++) {
            if(!vis[i]){

            }
        }
    }
}
