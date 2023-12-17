package com.example.demo.atcoder.abc282;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m  = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String str = arr[i];
            int[] a = new int[str.length()];
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='o'){
                    a[j]= 1;
                }
            }

            for (int j = i+1; j <n ; j++) {
                String t = arr[j];
                int[] b = new int[t.length()];
                boolean flag = true;
                for (int k = 0; k < t.length(); k++) {
                    if(t.charAt(k)=='o'){
                        b[k]= 1;
                    }
                    if(a[k]+b[k]==0){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans++;
                }

            }
        }
        System.out.println(ans);
    }
}
