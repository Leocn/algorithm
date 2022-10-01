package com.example.demo.atcoder.abc267;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        if(arr[0]!='0'){
            System.out.println("No");
            return;
        }
        int[] sum = new int[7];
        if(arr[6]=='1'){
            sum[0]++;
        }
        if(arr[3]=='1'){
            sum[1]++;
        }
        if(arr[7]=='1'){
            sum[2]++;
        }
        if(arr[1]=='1'){
            sum[2] ++;
        }
        if(arr[4]=='1'){
            sum[3] ++;
        }
        if(arr[2]=='1'){
            sum[4] ++;
        }
        if(arr[8]=='1'){
            sum[4] ++;
        }
        if(arr[5]=='1'){
            sum[5] ++;
        }
        if(arr[9]=='1'){
            sum[6] ++;
        }
        for (int i = 1; i < 6; i++) {
            if(sum[i]==0 ){
                boolean flag = false;
                for (int j = 0; j <i ; j++) {
                    if(sum[j]>0){
                        flag =true;
                    }
                }
                boolean flag1 = false;
                for (int j = i+1; j <7 ; j++) {
                    if(sum[j]>0){
                        flag1 =true;
                    }
                }
                if(flag&& flag1){

                    System.out.println("Yes");
                    return;
                }

            }
        }
        System.out.println("No");


    }
}
