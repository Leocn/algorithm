package com.example.demo.atcoder.abc321;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i <=100; i++) {
            List<Integer> l = new ArrayList<>(list);
            l.add(i);
            Collections.sort(l);
            int s = 0;
            for (int j = 1; j <n-1 ; j++) {
                s += l.get(j);

            }
            if(s>=x){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);





    }
}
