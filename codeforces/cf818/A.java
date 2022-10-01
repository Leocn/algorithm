package com.example.demo.codeforces.cf818;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = n;
            int left = n/2+ n/3;
//            int start =1;
//            while (start*3<n){
//                left +=2;
//                start ++;
//            }
            ans+= 2*left;
            System.out.println(ans);
        }
    }

}
