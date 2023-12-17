package com.example.demo.codeforces.cf834;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int f = Math.min(a, b);
            int tar = Math.max(a, b);
            if(f==tar){
                System.out.println(0);
                continue;
            }
            if(tar - f>=x ){
                System.out.println(1);
                continue;
            }
            if((f+ x> r && f-x <l) || (tar+x >r && tar-x<l) ){
                System.out.println(-1);
                continue;
            }

            if(f-x>=l){
                System.out.println(2);
                continue;
            }
            if(tar+x <= r){
                System.out.println(2);
                continue;
            }
            System.out.println(3);

        }

    }
}
