package com.example.demo.atcoder.arc136;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        int[] cnt = new int[5001];
        for (int i = 0; i < n; i++) {
            arrA[i] = scanner.nextInt();
            cnt[arrA[i]]++;
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = scanner.nextInt();
            cnt[arrB[i]]--;
        }
        for (int i = 0; i < 5001; i++) {
            if(cnt[i]!=0){
                System.out.println("No");
                return;
            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = i; j <n ; j++) {

            }
        }



    }
}
