package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class CF809A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            char[] ans = new char[m];
            Arrays.fill(ans, 'B');
            int[] record = new int[n];
            for(int i=0; i<n; i++){
                record[i] = sc.nextInt();
            }

            for(int i=0; i<n; i++){
                int a = record[i]-1;
                int b = m -record[i];
                int min = Math.min(a, b);
                if(ans[min]!='A'){
                    ans[min] = 'A';
                }else{
                    ans[Math.max(a,b)]= 'A';
                }
            }
            System.out.println(new String(ans));
        }

    }
}
