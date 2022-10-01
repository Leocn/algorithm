package com.example.demo.codeforces;

import java.util.Scanner;

public class CF806C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] target = new int[n];
            for(int i=0; i<n; i++){
                target[i] = sc.nextInt();
            }
            int[] ans = new int[n];
            for(int i=0;i<n; i++){

                int temps = sc.nextInt();
                String str = sc.next();
                char[] chars = str.toCharArray();
                int d = 0;
                for(int j=0; j<temps; j++){
                    if(chars[j]=='U'){
                        d++;
                    }else{
                        d--;
                    }
                }
                ans[i] = (target[i]-d +20) %10;

            }
            for(int i=0; i<ans.length; i++){
                if(i==ans.length-1){
                    System.out.println(ans[i]);
                }else {
                    System.out.println(ans[i] +" ");
                }

            }
        }
    }
}
