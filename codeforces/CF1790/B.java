package com.example.demo.codeforces.CF1790;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int s = sc.nextInt();
            int r = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int left = r;
            int from = s-r;
            n--;
            sb.append(s-r).append(" ");
            while (left>0 ){
                if(left<n-1+from){
                    from--;
                    continue;
                }
                sb.append(from).append(" ");
                left -= from;
                n--;
            }
            System.out.println(sb);

        }
    }
}
