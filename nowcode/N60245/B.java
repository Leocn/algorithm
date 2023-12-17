package com.example.demo.nowcode.N60245;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr  = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        char[] cs = sc.next().toCharArray();
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new int[26]);
            map.get(arr[i])[cs[i]-'A']++;
        }
        long ans = 0;
        for(Map.Entry<Integer, int[]> e: map.entrySet()){
            int[] v = e.getValue();
            for(int i=0; i<26;i++){
                for (int j = i+1; j <26 ; j++) {
                    ans += (long)v[i]*v[j];
                }
            }
        }
        System.out.println(ans);

    }
}
