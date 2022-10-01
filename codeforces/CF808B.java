package com.example.demo.codeforces;

import java.util.Scanner;

public class CF808B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            int[] ans = new int[n];
            boolean flag = true;
            for(int i=1; i<=n; i++){
                int last = (left )%i;
                if(last == 0){
                    ans[i-1] = left;
                    continue;
                }
                if(left+ i-last >right){
                    System.out.println("NO");
                    flag = false;
                    break;
                }else {
                    ans[i-1] = left+i-last;
                }
            }
            if(flag){
                System.out.println("YES");
                for(int i=0; i<n ;i++){
                    if(i==n-1){
                        System.out.println(ans[i]);
                    }else{
                        System.out.println(ans[i] + " ");
                    }
                }
            }


        }
    }
}
