package com.example.demo.codeforces.tfr8;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Map<Integer,Integer> map = new HashMap<>();
            int[] pre = new int[n];
            pre[0] = 1;
            map.put(arr[0], 1);
            int max = 1;
            for (int i = 1; i < n; i++) {
                int c = map.getOrDefault(arr[i],0)+1;
                map.put(arr[i],c);
                max = Math.max(max, c);
                pre[i] = max;
            }
            map = new HashMap<>();
            int[] suf = new int[n];
            map.put(arr[n-1], 1);
            max = 1;
            for (int i = n-2; i >=0; i--) {
                int c = map.getOrDefault(arr[i],0)+1;
                map.put(arr[i],c);
                max = Math.max(max, c);
                suf[i] = max;
            }
            int ans = 2;
            for (int i = 1; i < n-1; i++) {
                ans = Math.max(ans, 2*Math.min(pre[i], suf[i+1]));
            }
            out.println(ans);


        }
        out.close();
    }

}
