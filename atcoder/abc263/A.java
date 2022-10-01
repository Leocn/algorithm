package com.example.demo.atcoder.abc263;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Set<Integer> a = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int last = 0;
        for (int i = 0; i < 5; i++) {
            int s = scanner.nextInt();
            a.add(s);
            map.put(s, map.getOrDefault(s,0)+1);
            last = s;
        }
        if(a.size()!=2){
            System.out.println("No");
            return;
        }
        if(map.get(last) !=2&& map.get(last) !=3){
            System.out.println("No");
            return;
        }
        System.out.println("Yes");




    }
}
