package com.example.demo.codeforces.cf811;


import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] sa = new int[n];
            for (int i = 0; i < n; i++) {
                sa[i] = sc.nextInt();
            }

            int[] count = new int[20];
            int max = Integer.MIN_VALUE;
            int min =Integer.MAX_VALUE;
            for(int i=0; i<n;i++){
               count[sa[i]%20]++;
               min = Math.min(min, sa[i]);
                max = Math.max(max, sa[i]);
            }

            int m1 = 0, m2 = 0, m3 =0, m4 =0;
            m1 += count[1];
            m1 += count[2];
            m1 += count[4];
            m1 += count[8];
            m1 += count[16];
            m1 += count[13];
            m1 += count[17];
            m1 += count[19];

            m2 += count[3];
            m2 += count[6];
            m2 += count[12];
            m2 += count[14];
            m2 += count[18];
            m2 += count[7];
            m2 += count[11];
            m2 += count[9];

            m3 += count[5];
            m3 += count[10];

            m4 += count[15];
            m4 += count[0];

            String ans = (m1==n || m2==n|| (m3==n&&(max-min<=5) )|| (m4==n&&(max-min<=5)))? "Yes" : "No";
            System.out.println(ans);
        }
    }
}
