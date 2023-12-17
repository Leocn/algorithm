package com.example.demo.codeforces.CF1804;

import java.io.PrintWriter;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        out:while (t-->0){
            long n = sc.nextInt();
            long x = sc.nextInt();
            long p = sc.nextInt();
            for (int i = 1; i <=2*n ; i++) {
                long s = (long) i *n-x;
                long left = 1, right = p+1;
                while (left<right){
                    long mid = left+right>>1;
                    long cnt = (mid+1)*mid/2;
                    if(cnt==s){
                        out.println("YES");
                        continue out;
                    }else if(cnt<s){
                        left = mid+1;
                    }else {
                        right = mid;
                    }

                }

            }
            out.println("NO");

        }
        out.close();
    }
}
