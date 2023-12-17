package com.example.demo.GCJ;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int[] arr = new int[26];
            for (int i = 0; i < 26; i++) {
                arr[i] = sc.nextInt();
            }
            boolean flag = false;
            int n = sc.nextInt();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                char[] cs = sc.next().toCharArray();
                for(char c :cs){
                    sb.append(arr[c-'A']);
                }
                String s = sb.toString();
                if(set.contains(s)){
                    flag = true;
                }
                set.add(s);
            }
            if(flag){
                System.out.println("Case #"+k + ": " + "YES");
            }else {
                System.out.println("Case #"+k + ": " + "NO");
            }

        }

    }
}
