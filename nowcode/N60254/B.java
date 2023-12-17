package com.example.demo.nowcode.N60254;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLong());
        }
        while (k-->0){
            long max = -1;
            int loc = -1;
            for (int i = 1; i <list.size()-1 ; i++) {
                long a1 = list.get(i-1);
                long a2 = list.get(i);
                long a3 = list.get(i+1);

                long big = (a3-a1) * (a3-a1);
                long small = (a2-a1) *   (a2-a1) + (a3-a2)*(a3-a2);
                if( big - small>max){
                    max = big-small;
                    loc = i;
                }
            }
            long res = list.remove(loc);
        }
        long ans = 0;
        for (int i = 1; i < list.size(); i++) {

            long a1 = list.get(i-1);
            long a2 = list.get(i);
            ans += (a2-a1) *   (a2-a1);
        }
        System.out.println(ans);

    }
}
