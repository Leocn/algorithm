package com.example.demo.codeforces.CF1808;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){

            int l = sc.nextInt(), r = sc.nextInt();
            int ans = -1, res = -1;
            for(int i= l; i<=Math.min(100+l, r); i++){
                int tem = i;
                int max = -1;
                int min = 10;
                while (tem>0){
                    int d = tem%10;
                    tem /= 10;
                    max = Math.max(d,max);
                    min = Math.min(d, min);
                }
                if(max-min>ans){
                    res = i;
                    ans = max - min;
                }
            }
            System.out.println(res);
        }
    }
}
