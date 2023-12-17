package com.example.demo.codeforces.CF1786;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int st = 1;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                while (i<n&& arr[i]<=st){

                    if(i<n-1 && !Objects.equals(arr[i+1], arr[i])){
                        st++;
                    }
                    i++;

                }
                if(i>=n){
                    break;
                }
                if(arr[i]!=st){
                    ans += arr[i]-st;
                }
                st++;


            }
            System.out.println(ans);

        }
    }
}
