package com.example.demo.codeforces.CF1772;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int diff = n-k;
            int s = 1;
            while (s*(s+1)/2<=diff){
                if(s*(s+1)/2==diff){
                    break;
                }
                s++;
            }
            List<Integer> ans = new ArrayList<>();
            int a = 1, d = 1, cnt = 0;
            while ( d<=s+1 && cnt<k){

                ans.add(a);
                a+=d;
                d++;
                cnt++;
            }
            for (int i = n; ans.size()<k ; i--) {
                ans.add(i);
            }
            Collections.sort(ans);


            StringBuilder sb = new StringBuilder();
            for(int m: ans){
                sb.append(m).append(" ");
            }
            System.out.println(sb);
        }
    }
}
