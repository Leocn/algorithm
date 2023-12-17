package com.example.demo.atcoder.abc285;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            map.put(a, b);
        }

    }
}
