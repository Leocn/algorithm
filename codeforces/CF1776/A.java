package com.example.demo.codeforces.CF1776;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int s = 0, cnt = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if(arr[i]-s>=240){
                    cnt+=2;
                }
                if(arr[i]-s>=120){
                    cnt+=1;
                }
                s = arr[i];
            }
            if(1440 -s >=240){
                cnt+=2;
            }
            if(1440 -s >=120){
                cnt+=1;
            }
            if(cnt>=2){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
