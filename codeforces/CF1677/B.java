package com.example.demo.codeforces.CF1677;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt(), m = sc.nextInt();
            char[] cs = sc.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            int[] dp = new int[n*m];
            Map<Integer,Integer> map = new HashMap<>();
            int cnt = 0;
            int curM = 0;
            for (int i = 0; i < cs.length; i++) {
                int d = i%m;
                if(cs[i]=='1'){
                    curM++;
                    if(!map.containsKey(d)){
                        cnt++;
                        map.put(d,1);
                    }
                }
                if(i>=m){
                    curM -= cs[i-m]-'0';
                }

                dp[d] = dp[d] + (curM>0?1:0);
                sb.append(cnt+ dp[d]).append(" ");
            }
            System.out.println(sb);
        }


    }
}
