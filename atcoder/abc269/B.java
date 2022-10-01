package com.example.demo.atcoder.abc269;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.next().toCharArray();
        }
        int s = -1;
        int a = 0, b = 0, c = 0, d =0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(arr[i][j]=='#'){
                  if(s==-1){
                      a= i+1;
                      b=j+1;
                      s++;
                      c= i+1;
                      d = j+1;
                  }  else{
                      c= i+1;
                      d = j+1;
                  }
                }
            }
        }
        System.out.println(a +" "+ c);
        System.out.println(b +" "+ d);

    }
}
