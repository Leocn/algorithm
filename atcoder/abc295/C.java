package com.example.demo.atcoder.abc295;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        int[] arr  = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(set.contains(arr[i])){
                ans++;
                set.remove(arr[i]);
            }else {
                set.add(arr[i]);
            }
        }
        System.out.println(ans);
    }
}
