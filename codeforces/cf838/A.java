package com.example.demo.codeforces.cf838;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            if(sum%2==0){
                System.out.println(0);
                continue;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int tem = 0;
                if(arr[i]%2==0){

                    while (arr[i]%2==0){
                        arr[i] /= 2;
                        tem++;
                    }

                }else{
                    while (arr[i]%2==1){
                        arr[i] /= 2;
                        tem++;
                    }
                }
                ans = Math.min(tem,ans);
            }
            System.out.println(ans);
        }
    }

}
