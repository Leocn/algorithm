package com.example.demo.codeforces.CF1797;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q =3;
            int ansx = 0 , ansy = 0;
            int max = 0, min = 0;

            StringBuilder sb = new StringBuilder();
            sb.append("?").append(" ").append("1").append(" ").append("1");

            System.out.println(sb);
            System.out.flush();
            int c = sc.nextInt();
            max =c+1;

            if(max<=n){
                sb = new StringBuilder();
                sb.append("?").append(" ").append(max).append(" ").append(1);
                System.out.println(sb);
                System.out.flush();
                c = sc.nextInt();
                if(c+1==max){
                    ansy = c+1;
                    sb = new StringBuilder();
                    sb.append("?").append(" ").append(1).append(" ").append(ansy);
                    System.out.println(sb);
                    System.out.flush();
                    ansx = sc.nextInt()+1;
                }else {
                    ansx = max;
                    ansy = c+1;
                }
            }else {
                ansy = max;
                sb = new StringBuilder();
                sb.append("?").append(" ").append(1).append(" ").append(ansy);
                System.out.println(sb);
                System.out.flush();
                ansx = sc.nextInt()+1;

            }


            System.out.println("!" + " " + ansx + " " + ansy);
            System.out.flush();

        }

    }


}
