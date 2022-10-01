package com.example.demo.codeforces;

import java.util.*;

public class CF806D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] ans = new int[n];
            Set<String> set = new HashSet<>();
            String[] records = new String[n];
            for(int i=0; i<n;i++){
                String str = sc.next();
                set.add(str);
                records[i] = str;
            }
            for (int i = 0; i < n; i++) {
                String value = records[i];
                for(int j=1; j<value.length();j++){
                    String s = value.substring(0,j);
                    String next = value.substring(j);
                    boolean a = set.contains(s);
                    boolean b = set.contains(next);
                    if( a&&b){
                        ans[i] = 1;
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int c: ans){
                sb.append(c);
            }
            System.out.println(sb);
        }


    }
}
