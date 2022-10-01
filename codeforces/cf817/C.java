package com.example.demo.codeforces.cf817;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String[] s1 = new String[n];
            String[] s2 = new String[n];
            String[] s3 = new String[n];
            for (int i = 0; i < n; i++) {
                s1[i]  = sc.next();
            }
            for (int i = 0; i < n; i++) {
                s2[i]  = sc.next();
            }
            for (int i = 0; i < n; i++) {
                s3[i]  = sc.next();
            }
            Map<String,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(s1[i], map.getOrDefault(s1[i],0)+1);
                map.put(s2[i], map.getOrDefault(s2[i],0)+1);
                map.put(s3[i], map.getOrDefault(s3[i],0)+1);
            }
            int[] ans = new int[3];
            for (int i = 0; i < n; i++) {
                int count = map.get(s1[i]);
                if(count==1){
                    ans[0]+=3;
                }else if(count==2){
                    ans[0] +=1;
                }

                count = map.get(s2[i]);
                if(count==1){
                    ans[1]+=3;
                }else if(count==2){
                    ans[1] +=1;
                }

                count = map.get(s3[i]);
                if(count==1){
                    ans[2]+=3;
                }else if(count==2){
                    ans[2] +=1;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ans[0]).append(" ").append(ans[1]).append(" ").append(ans[2]);
            System.out.println(sb);
            

        }

    }
}
