package com.example.demo.atcoder.abc290;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        for (int i = 0; i < n; i++) {
            if(arr[i]=='o' ){
                if(k>0){
                    k--;
                }else {
                    arr[i] ='x';
                }
            }
        }
        System.out.println(arr);
    }
}
