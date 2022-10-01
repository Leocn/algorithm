package com.example.demo.codeforces.ecf134;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            Integer[] a = new Integer[n];
            Integer[] b = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];

            int ans = 0;

            ll:
            for (int i = 31; i >=0 ; i--) {
                Map<Integer,Integer> map = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if(((a[j]>>i)&1) == 1){
                        map.put(arr1[j], map.getOrDefault(arr1[j],0) +1);
                    }
                    if(((b[j]>>i)&1) == 0){
                        map.put(arr2[j], map.getOrDefault(arr2[j],0) -1);
                    }

                }
                for (int j = 0; j <n ; j++) {
                    if(map.getOrDefault(arr1[j],0)!=0){
                        continue ll;
                    }
                }
                ans += (1<<i);
                for (int j = 0; j <n ; j++) {
                    if(((a[j]>>i)&1) == 1){
                        arr1[j] = arr1[j]*2 +1;
                    }else {
                        arr1[j] = arr1[j]*2 +2;
                    }
                    if(((b[j]>>i)&1) == 0){
                        arr2[j] = arr2[j]*2 +1;
                    }else {
                        arr2[j] = arr2[j]*2 +2;
                    }

                }

            }
            System.out.println(ans);
        }
    }
}
