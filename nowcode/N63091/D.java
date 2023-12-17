package com.example.demo.nowcode.N63091;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] cnt = new int[10][32];
        int[][] cnt2 = new int[10][30];
        int[] cnt3 = new int[10];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int c = 0, cur = arr[i];
            int a = 0, b = 0;
            while (cur>0){
                if(cur%10==0){
                    cur/=10;
                    c++;
                }else {
                    break;
                }
            }

            while (cur>0){
                if(cur%2==0){
                    cur/=2;
                    a++;
                }else {
                    break;
                }

            }

            while (cur>0){
                if(cur%5==0){
                    cur/=5;
                    b++;
                }else {
                    break;
                }
            }
            int r = Math.max(0,x-c);
            for (int j = r; j <10 ; j++) {
                ans += cnt3[j];
            }


            for (int j = 0; j < 10; j++) {
                if(j>=r){
                    for (int k = 0; k < 30; k++) {
                        ans+=cnt2[j][k];
                    }
                    for (int k = 0; k < 32; k++) {
                        ans+=cnt[j][k];
                    }
                }else{
                    int left = r-j;

                    if(a>0){
                        if(left>a){
                            continue;
                        }
                        for (int k = Math.min(a, left); k < 30; k++) {
                            ans+=cnt2[j][k];
                        }
                    }else if(b>0){

                        if(left>b){
                            continue;
                        }
                        for (int k =  Math.min(b,left); k < 32; k++) {
                            ans+=cnt[j][k];
                        }
                    }
                }
            }

            if(a==0 && b ==0){
                cnt3[c]++;
            }else {
                if(a>0){
                    cnt[c][a]++;
                }else {
                    cnt2[c][b]++;
                }
            }
        }
        System.out.println(ans);
    }
}
