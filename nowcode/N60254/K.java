package com.example.demo.nowcode.N60254;

import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;
        long c  = 1, d =0;
        while (sum<n){
            d +=c;
            sum+=d;
            c++;
            System.out.println(c);
        }
        c--;
        System.out.println(c);
        sum =0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=c ; i++) {
            if(sum +(c-i+1)*i<=n){
                sb.append(i).append(" ");
                sum += (c-i+1)*i;
            }else {
                long res = (n-sum)/(c-i+1);
                sb.append(res).append(" ");
                sum += res*( c-i+1);
            }
        }
        System.out.println(sb);
    }
}
