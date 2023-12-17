package com.example.demo.atcoder.abc295;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c= sc.nextInt();
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                if(arr[i][j]=='.'){
                    continue;
                }
                if(arr[i][j]>='1' && arr[i][j]<='9'){
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < c; l++) {
                        if(arr[k][l]>='1' && arr[k][l]<='9'){
                            if(Math.abs(k-i) + Math.abs(l-j)<=Integer.parseInt(arr[k][l]+"")){
                                arr[i][j]='.';
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                if(arr[i][j]>='1' && arr[i][j]<='9'){
                    arr[i][j]='.';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(new String(arr[i]));
        }
    }
}
