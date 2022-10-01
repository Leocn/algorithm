package com.example.demo.codeforces.cf821;

import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x==0 && y==0){
                out.println("-1");
                continue;
            }
            if((x==0 && ((n-1)%y!=0)) ||   (y==0 && ((n-1)%x!=0)) ){
                out.println("-1");
                continue;
            }
            if((x>0&& y>0) ){
                out.println("-1");
                continue;
            }
            int s = 2;
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n-1; i++) {

                sb.append(s).append(" ");
                count++;
                if(count== Math.max(x,y)){
                    s +=  Math.max(x,y);
                    count= 0;
                }


            }
            out.println(sb);

        }
        out.close();
    }
}