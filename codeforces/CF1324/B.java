package com.example.demo.codeforces.CF1324;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt(), count = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
                for(int j=i+2;j<n;j++){
                    if(arr[i] == arr[j])
                        count++;
                }
            }
            if(count>0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
