package com.example.demo.codeforces.cf813;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = n%2; i <n ; i++) {
                sb.append(i+2).append(" ").append(i+1).append(" ");
                i++;
            }
            if(n%2==1){
                sb.insert(0, "1 ");
            }
            System.out.println(sb);
        }
    }
}
