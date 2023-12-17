package com.example.demo.codeforces.cf832;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int min = Integer.MAX_VALUE;
            int loc = 0;
            for(int i =0; i<n; i++){
                arr[i]= sc.nextInt();
                if(arr[i]<min){
                    loc = i;
                    min = arr[i];
                }
            }

            if(loc==0){
                    System.out.println("Bob");

            }else{
            System.out.println("Alice");
            }
        }

    }
}
