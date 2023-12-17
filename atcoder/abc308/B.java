package com.example.demo.atcoder.abc308;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] arr  = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(sc.next(), i);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        int p = sc.nextInt();
        for (int i = 0; i < m; i++) {
            map2.put(i,sc.nextInt());
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int t = map.getOrDefault(arr[i],-1);
            if(t==-1){
                sum += p;
            }else {
                sum += map2.get(t);
            }

        }
        System.out.println(sum);
    }
}
