package com.example.demo.GCJ;

import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            long a = sc.nextLong();
            int s = 26;
            char ans;
            long left = 1, right = 10000000;
            while (left<right){
                long m = left+right>>1;
                if(m*(m+1)/2*26<=a){
                    left = m+1;
                }else {
                    right = m;
                }
            }
            left--;
            long d = a- (left+1)*left/2 *26;
            if(d==0){
                ans = 'Z';
            }else {
                ans =(char)( (d-1)/(left+1)+'A');
            }
            System.out.println("Case #"+k+": "+ans);
        }
    }
}
