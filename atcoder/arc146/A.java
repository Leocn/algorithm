package com.example.demo.atcoder.arc146;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        String ans = "";
        int a  = arr[n-1];
        int b = arr[n-2];
        int c = arr[n-3];

        if(check(a,b)){
            if(check(a,c)){
                ans += a;
                if(check(b,c)){
                    ans += b;
                    ans += c;
                }else {
                    ans+=c;
                    ans += b;
                }

            }else {
                ans += c;
                ans += a;
                ans += b;

            }
        }else {
            if(check(b, c)){
                ans +=b;
                if(check(a,c)){
                    ans+= a;
                    ans += c;
                }else{
                    ans += c;
                    ans +=a;
                }
            }else {
                ans +=c;
                ans += b;
                ans +=a;
            }
        }

        System.out.println(ans);
    }
    private static boolean check(int x, int y){
        int a = (x+"").length();
        int b = (y+"").length();
        if(a>b){
            return x > y * Math.pow(10, a - b);

        }else if(a==b){
            return true;
        }else {
            return y > x * Math.pow(10, b - a);
        }
    }
}
