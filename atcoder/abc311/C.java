package com.example.demo.atcoder.abc311;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;


public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            g[i] = new ArrayList<>();
        }
        int cnt[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            g[i+1].add(b);
            cnt[b]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <=n; i++) {
            if(cnt[i]==0){
                dq.add(i);
            }
        }
        while (dq.size()>0){
            int p = dq.poll();
            ArrayList<Integer> list = g[p];
            for(int c : list){
                cnt[c]--;
                if(cnt[c]==0){
                    dq.add(c);
                }
            }
        }
        for (int i = 1; i <=n ; i++) {
            if(cnt[i]==0){
                continue;
            }
            dq.add(i);
            int ans = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(" ");
            while (dq.size()>0){
                int p = dq.poll();
                ArrayList<Integer> list = g[p];
                for(int c : list){

                    if(c==i){
                        System.out.println(ans);
                        System.out.println(sb);
                        return;
                    }
                    ans++;
                    sb.append(c).append(" ");
                    dq.add(c);

                }
            }
        }


    }
}

