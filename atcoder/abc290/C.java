package com.example.demo.atcoder.abc290;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int loc =0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==loc){
                while (i+1<n&&arr[i]==arr[i+1]){
                    i++;
                }
                k--;
                loc++;
                if(k==0){
                    break;
                }
            }else {
                break;
            }
        }
        System.out.println(loc);
    }
}
