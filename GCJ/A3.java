package com.example.demo.GCJ;

import java.util.*;

public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Set<Integer> set = new HashSet<>();
            set.add(arr[0]);

            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            boolean flag = true;
            for (int i = 1; i < n; i++) {
                if(arr[i-1]==arr[i]){
                    continue;
                }
                if(set.contains(arr[i])){
                    flag = false;
                    break;
                }
                list.add(arr[i]);
                set.add(arr[i]);
            }
            if(!flag){
                System.out.println("Case #"+k+": IMPOSSIBLE" );
            }else {
                StringBuilder sb = new StringBuilder();
                for(int s: list){
                    sb.append(s).append(" ");
                }
                System.out.println("Case #"+k+": "+sb);
            }
        }
    }
}
