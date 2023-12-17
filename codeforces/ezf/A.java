package com.example.demo.codeforces.ezf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long l  = sc.nextLong();
            long r = sc.nextLong();
            long i = 1;
            int ans =0;
            while (i*i<=r){
                if(i*i>=l){
                    ans ++;
                }
                i++;
            }
            System.out.println(ans);
        }
    }

}
