package com.example.demo.codeforces.CF1409;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextLong();
            int s = sc.nextInt();
            long tem = n;
            int sum = 0;
            while (tem>0){
                sum += tem%10;
                tem/=10;
            }
            long ans = 0;
            long l = 0, f = 1;

            while (sum>s){
                long d = n%10;
                if(d+l!=0){
                    sum-= d+l;
                    sum+=1;
                    ans += (10-d-l)*f;
                    l = 1;
                }

                n/=10;
                f*=10;

            }
            System.out.println(ans);
        }


    }

}
