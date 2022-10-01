package com.example.demo.atcoder.abc265;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        long t = sc.nextInt();
        Map<Integer, Long> map = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n-1; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            map.put(sc.nextInt()-1, (long) sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            if(map.containsKey(i)){
                t += map.get(i);
            }
            t -= arr[i];
            if(t<=0){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }
}
