package com.example.demo.codeforces.ecf135;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int ans =-1;
            int max = -1;
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if(arr[i]>=max){
                    ans = i;
                    max = arr[i];
                }
            }
            System.out.println(ans+1);



        }
    }
}
