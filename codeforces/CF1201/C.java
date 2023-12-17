package com.example.demo.codeforces.CF1201;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        int m = n/2;
        for (int i = m; i < n-1; i++) {
            if(arr[i].equals(arr[i+1])){
                continue;
            }else {
                long dis = (arr[i+1] - arr[i]);
                if( dis* (i-m+1)>k){
                   arr[i] +=  k/(i-m+1);
                    System.out.println(arr[i]);
                    return;
                }else{
                    k-= (dis)* (i-m+1);
                }
            }
        }
        System.out.println(arr[n-1] + k/(n-m));
    }
}
