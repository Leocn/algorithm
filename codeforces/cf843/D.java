package com.example.demo.codeforces.cf843;

import java.io.PrintWriter;
import java.util.*;

public class D {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] record = new int[n+1];

        for(int i=1; i<=n; i++){
            record[i] = sc.nextInt();
        }
        int len = Arrays.stream(record).max().getAsInt();
        len = Math.max(len, n+1);
        int max = 2*len+5;
        List<Integer>[] arr = new List[max];

        for (int i = 0; i < max; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            arr[record[i]].add(i);
        }
        int from = sc.nextInt();
        int to = sc.nextInt();
        if(from==to){
            out.println(1);
            out.println(from);
            out.close();
            return;
        }
        List[] g = new List[max];
        for(int i=1; i<max;i++){
            g[i] = new ArrayList();
        }
        int[] notPrime = new int[max];
        for(int i=2; i<=len; i++){
            if(notPrime[i]>0){
                continue;
            }
            for(int j=i; j<=len;j+=i){
                if(j>i){
                    notPrime[j] = 1;
                }
                List<Integer> list = arr[j];
                for(int x : list){
                    g[i+len].add(x);
                    g[x].add(i+len);
                }
            }
        }
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(from);
        int[] dis = new int[max];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[from] = 0;
        o: while (dq.size()>0){
            int q = dq.poll();
            List<Integer> list = g[q];
            for(int x: list){
                if(dis[x]<Integer.MAX_VALUE) continue;
                dis[x] = q;
                if(x== to){
                    break o;
                }
                dq.add(x);
            }
        }
        if(dis[to] == Integer.MAX_VALUE){
            out.println(-1);
            out.close();
            return;
        }
        List<Integer> ans = new ArrayList<>();
        while(dis[to]!=0){
            ans.add(to);
            to = dis[to];
        }
        ans.add(from);
        Collections.reverse(ans);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int x: ans){
            if(x<=len){
                cnt++;
                sb.append(x).append(" ");
            }
        }
        out.println(cnt);
        out.println(sb);
        out.close();
    }
}
