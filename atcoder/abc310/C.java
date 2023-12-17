package com.example.demo.atcoder.abc310;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String re = new StringBuilder(s).reverse().toString();
            if(!map.containsKey(s) && !map.containsKey(re)){
                map.put(s, i);
                map.put(re,i);
                ans ++;
            }
        }
        System.out.println(ans);
    }
}
