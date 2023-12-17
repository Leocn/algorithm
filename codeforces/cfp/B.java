package com.example.demo.codeforces.cfp;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            Integer[] arr = new Integer[m];
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            int ans = n/k;
            int left = n%k;
            int d = left==0?0:1;
            int cnt = 1;
            int loc = m-1;
            while (loc-1 >=0 &&( arr[loc-1].equals(arr[loc]))){
                cnt++;
                loc--;
            }

            if(arr[m-1]>ans+d){
                System.out.println("NO");
                continue;
            }
            if(d==0 && arr[m-1] == ans){
                System.out.println("YES");
                continue;
            }
            if(arr[m-1] == ans+d){
                if(left>=cnt){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
                continue;
            }

            System.out.println("YES");

        }
    }
}
