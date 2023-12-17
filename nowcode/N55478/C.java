package com.example.demo.nowcode.N55478;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            String str = sc.next();
            char[] cs = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            sb.append(cs[0]);
            int n = cs.length;
            for (int i = 1; i < n; i++) {
                if(cs[i]<=sb.charAt(0)){
                    sb.insert(0, cs[i]);
                }else {
                    sb.append(cs[i]);
                }
            }
            System.out.println(sb);

        }
    }

}
