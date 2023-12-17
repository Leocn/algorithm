package com.example.demo.nowcode;

import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1){
            System.out.println(1);
            return;
        }
        if(n==2){
            System.out.println("2 1 2");
            return;
        }
        if(n%2==0){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i >=3; i-=2) {
            int t = i;
            while (t-->1){
                sb.append(i).append(" ");
                sb.append(i-1).append(" ");
            }
            sb.append(i).append(" ");
        }
        sb.append(1);
        System.out.println(sb);



    }
}
