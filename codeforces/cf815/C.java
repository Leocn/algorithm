package com.example.demo.codeforces.cf815;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] arr = new char[n][m];
            int sum = 0;
            int sumZ = 0;

            for (int i = 0; i <n ; i++) {
                arr[i] = sc.next().toCharArray();
            }
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] =='1'){
                        sum++;
                    }else {
                        sumZ++;
                    }
                }
            }
            int ans = sum;
            boolean flag = false;
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j]=='0'){
                        if((i-1>=0 &&arr[i-1][j]=='0')
                            || (i+1<n  &&arr[i+1][j]=='0')
                        || (j+1<m  &&arr[i][j+1]=='0')
                        || (j-1>=0 &&arr[i][j-1]=='0')
                        || (i-1>=0 && j-1>=0 &&  arr[i-1][j-1]=='0')
                        || (i-1>=0 && j+1<m  &&  arr[i-1][j+1]=='0')
                        || (i+1<n && j-1>=0  &&  arr[i+1][j-1]=='0')
                        || (i+1<n && j+1<m  &&  arr[i+1][j+1]=='0') ){
                            flag = true;
                        }
                    }
                }
            }
            if(flag) {
                System.out.println(ans);
                continue;
            }
            if(sumZ==0){
                System.out.println(ans-2);
                continue;
            }
            System.out.println(ans-1);



        }
    }
}
