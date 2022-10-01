package com.example.demo.atcoder.abc264;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('t',1);
        map.put('c',2);
        map.put('o',3);
        map.put('d',4);
        map.put('e',5);
        map.put('r',6);
        int ans = 0;
        for (int i = 0; i <7 ; i++) {

            map.put(cs[i],i);
        }

        System.out.println(ans);

    }
}
